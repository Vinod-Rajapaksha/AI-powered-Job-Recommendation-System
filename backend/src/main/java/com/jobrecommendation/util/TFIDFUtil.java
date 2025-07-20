package com.jobrecommendation.util;

import java.util.*;
import java.util.stream.Collectors;

public class TFIDFUtil {
    public static double calculateMatchedScore(String resumeText, String jobText) {
        // Split into words
        List<String> resumeWords = Arrays.asList(resumeText.toLowerCase().split("\\W+"));
        List<String> jobWords = Arrays.asList(jobText.toLowerCase().split("\\W+"));

        // Build word frequency maps
        Map<String, Long> resumeFreq = resumeWords.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        Map<String, Long> jobFreq = jobWords.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        // Combine all unique words
        Set<String> allWords = new HashSet<>(resumeFreq.keySet());
        allWords.addAll(jobFreq.keySet());

        // Build vectors
        List<Double> resumeVector = new ArrayList<>();
        List<Double> jobVector = new ArrayList<>();
        for (String word : allWords) {
            resumeVector.add(resumeFreq.getOrDefault(word, 0L).doubleValue());
            jobVector.add(jobFreq.getOrDefault(word, 0L).doubleValue());
        }

        // Calculate cosine similarity
        double dotProduct = 0.0, normA = 0.0, normB = 0.0;
        for (int i = 0; i < resumeVector.size(); i++) {
            dotProduct += resumeVector.get(i) * jobVector.get(i);
            normA += Math.pow(resumeVector.get(i), 2);
            normB += Math.pow(jobVector.get(i), 2);
        }
        return normA == 0 || normB == 0 ? 0.0 : dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}