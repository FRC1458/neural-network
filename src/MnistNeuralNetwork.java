import java.util.Arrays;
import java.util.Random;

public class MnistNeuralNetwork {

  // The MNIST dataset contains 28x28 grayscale images of handwritten digits
  // ranging from 0 to 9.
  private static final int IMAGE_WIDTH = 28;
  private static final int IMAGE_HEIGHT = 28;
  private static final int NUM_CLASSES = 10;

  private static final int NUM_HIDDEN_NODES = 100;
  private static final int NUM_EPOCHS = 10;

  // Weights and biases for the three layers of the network
  private float[][] weightsInputToHidden;
  private float[] biasesInputToHidden;
  private float[][] weightsHiddenToOutput;
  private float[] biasesHiddenToOutput;

  public MnistNeuralNetwork() {
    // Initialize the weights and biases with random values
    Random random = new Random();
    weightsInputToHidden = new float[IMAGE_WIDTH * IMAGE_HEIGHT][NUM_HIDDEN_NODES];
    biasesInputToHidden = new float[NUM_HIDDEN_NODES];
    weightsHiddenToOutput = new float[NUM_HIDDEN_NODES][NUM_CLASSES];
    biasesHiddenToOutput = new float[NUM_CLASSES];

    for (int i = 0; i < IMAGE_WIDTH * IMAGE_HEIGHT; i++) {
      for (int j = 0; j < NUM_HIDDEN_NODES; j++) {
        weightsInputToHidden[i][j] = random.nextFloat();
      }
    }

    for (int i = 0; i < NUM_HIDDEN_NODES; i++) {
      biasesInputToHidden[i] = random.nextFloat();
      for (int j = 0; j < NUM_CLASSES; j++) {
        weightsHiddenToOutput[i][j] = random.nextFloat();
      }
    }

    for (int i = 0; i < NUM_CLASSES; i++) {
      biasesHiddenToOutput[i] = random.nextFloat();
    }
  }

  // Sigmoid activation function
  private float sigmoid(float x) {
    return (float) (1 / (1 + Math.exp(-x)));
  }

  // Feed-forward calculation of the network's output
  private float[] calculateOutput(float[] input) {
    // Input to hidden layer
    float[] hiddenLayer = new float[NUM_HIDDEN_NODES];
    for (int i = 0; i < NUM_HIDDEN_NODES; i++) {
      float sum = 0;
      for (int j = 0; j < IMAGE_WIDTH * IMAGE_HEIGHT; j++) {
        sum += input[j] * weightsInputToHidden[j][i];
      }
      sum += biasesInputToHidden[i];
      hiddenLayer[i] = sigmoid(sum);
    }

    // Hidden to output layer
    float[] output = new float[NUM_CLASSES];
    for (int i = 0; i < NUM_CLASSES; i++) {
