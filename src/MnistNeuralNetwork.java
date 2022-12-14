//---Imports--

import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

public class MnistNeuralNetwork {
    public static void main(String[] args) throws Exception {
        // Load the data into memory
        DataSetIterator mnistTrain = new MnistDataSetIterator(64, true, 12345);
        DataSetIterator mnistTest = new MnistDataSetIterator(64, false, 12345);

        // Create the network configuration
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(12345)
            .weightInit(WeightInit.XAVIER)
            .updater(new Nesterovs(0.006, 0.9))
            .list()
            .layer(new DenseLayer.Builder()
                .nIn(28 * 28)
                .nOut(100)
                .activation(Activation.RELU)
                .build())
            .layer(new Output

//WIP