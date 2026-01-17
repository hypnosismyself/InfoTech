package Lab4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4 extends JFrame {
    private JTextField array1Field;
    private JTextField array2Field;
    private JTextField valueField;
    private JTextField wordField;
    private JTextField matrixField;

    private JPanel Lab4;

    public Lab4() {
        setTitle("Никольский В.А. | Лабораторная работа 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Вкладка 1: Бесконечные ряды, таблица функции
        GridLayout gridLab1 = new GridLayout(3, 3, 20, 10);
        JPanel infiniteRowsPanel = new JPanel(gridLab1);
        JTextArea resultLab1TextArea = new JTextArea();

        JButton calcInfiniteRowsButton = new JButton("Вычислить ");
        calcInfiniteRowsButton.setMaximumSize(new Dimension(200, 50));
        JButton calcTabulationButton = new JButton("Обработать массивы");

        calcInfiniteRowsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLab1TextArea.setText(Lab1.TabulatorLab1.calc());
            }
        });
        infiniteRowsPanel.add(calcInfiniteRowsButton);

        calcTabulationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLab1TextArea.setText(Lab1.InfiniteRowLab1.calc());
            }
        });
        infiniteRowsPanel.add(calcTabulationButton);

        infiniteRowsPanel.add(resultLab1TextArea);

        // Вкладка 1: Массивы
        JPanel arraysPanel = new JPanel(new BorderLayout());
        arraysPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel arraysInputPanel = new JPanel(new GridLayout(3, 2));
        arraysInputPanel.add(new JLabel("Массив 1:"));
        array1Field = new JTextField();
        arraysInputPanel.add(array1Field);
        arraysInputPanel.add(new JLabel("Массив 2:"));
        array2Field = new JTextField();
        arraysInputPanel.add(array2Field);
        arraysInputPanel.add(new JLabel("Значение:"));
        valueField = new JTextField();
        arraysInputPanel.add(valueField);

        JButton arraysButton = new JButton("Обработать массивы");
        arraysButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processArrays();
            }
        });
        arraysInputPanel.add(arraysButton);

        arraysPanel.add(arraysInputPanel, BorderLayout.CENTER);

        // Вкладка 2: Слово
        JPanel wordPanel = new JPanel(new BorderLayout());
        wordPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel wordInputPanel = new JPanel(new GridLayout(1, 2));
        wordInputPanel.add(new JLabel("Слово:"));
        wordField = new JTextField();
        wordInputPanel.add(wordField);

        JButton wordButton = new JButton("Сортировать слово");
        wordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processWord();
            }
        });
        wordInputPanel.add(wordButton);

        wordPanel.add(wordInputPanel, BorderLayout.CENTER);

        // Вкладка 3: Матрица
        JPanel matrixPanel = new JPanel(new BorderLayout());
        matrixPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel matrixInputPanel = new JPanel(new GridLayout(1, 2));
        matrixInputPanel.add(new JLabel("Матрица:"));
        matrixField = new JTextField();
        matrixInputPanel.add(matrixField);

        JButton matrixButton = new JButton("Обработать матрицу");
        matrixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processMatrix();
            }
        });
        matrixInputPanel.add(matrixButton);

        matrixPanel.add(matrixInputPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Лабораторная 1", infiniteRowsPanel);
        tabbedPane.addTab("Массивы", arraysPanel);
        tabbedPane.addTab("Слово", wordPanel);
        tabbedPane.addTab("Матрица", matrixPanel);

        add(tabbedPane);
    }

    private void processArrays() {
//        String array1Str = array1Field.getText();
//        String array2Str = array2Field.getText();
//        String valueStr = valueField.getText();
//
//        String[] array1Parts = array1Str.split(",");
//        String[] array2Parts = array2Str.split(",");
//
//        int[] array1 = new int[array1Parts.length];
//        int[] array2 = new int[array2Parts.length];
//
//        for (int i = 0; i < array1Parts.length; i++) {
//            array1[i] = Integer.parseInt(array1Parts[i].trim());
//        }
//
//        for (int i = 0; i < array2Parts.length; i++) {
//            array2[i] = Integer.parseInt(array2Parts[i].trim());
//        }
//
//        int value = Integer.parseInt(valueStr);
//
//        ArrayProcessor processor = new ArrayProcessor(array1, array2);
//        processor.processArrays(value);
    }

    private void processWord() {
//        String word = wordField.getText();
//        BubbleSortWord processor = new BubbleSortWord();
//        processor.processWord(word);
    }

    private void processMatrix() {
//        String matrixStr = matrixField.getText();
//        String[] rows = matrixStr.split(";");
//
//        int[][] matrix = new int[rows.length][];
//
//        for (int i = 0; i < rows.length; i++) {
//            String[] rowParts = rows[i].split(",");
//            matrix[i] = new int[rowParts.length];
//            for (int j = 0; j < rowParts.length; j++) {
//                matrix[i][j] = Integer.parseInt(rowParts[j].trim());
//            }
//        }
//
//        MatrixProcessor processor = new MatrixProcessor(matrix);
//        processor.processMatrix();
    }

    public static void main() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Lab4 lab4 = new Lab4();
                lab4.setVisible(true);
            }
        });
    }
}