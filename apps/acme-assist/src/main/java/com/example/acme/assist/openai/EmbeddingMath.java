package com.example.acme.assist.openai;

import java.util.List;

/**
 * Utility class for the embedding math
 */
public class EmbeddingMath {
    public static double cosineSimilarity(List<Double> vectorX, List<Double> vectorY) {
        if (vectorX.size() != vectorY.size()) {
            throw new IllegalArgumentException("Vectors lengths must be equal");
        }

        double dotProduct = dotProduct(vectorX, vectorY);
        double normX = norm(vectorX);
        double normY = norm(vectorY);

        if (normX == 0 || normY == 0) {
            throw new IllegalArgumentException("Vectors cannot have zero norm");
        }

        return dotProduct / (Math.sqrt(normX) * Math.sqrt(normY));
    }

    public static double dotProduct(List<Double> vectorX, List<Double> vectorY) {
        if (vectorX.size() != vectorY.size()) {
            throw new IllegalArgumentException("Vectors lengths must be equal");
        }

        double result = 0;
        for (int i = 0; i < vectorX.size(); ++i) {
            result += vectorX.get(i) * vectorY.get(i);
        }

        return result;
    }

    public static double norm(List<Double> vector) {
        return dotProduct(vector, vector);
    }
}
