package Lab4;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4 extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();

    private JTextField wordField;
    private JTextField matrixField;

    private JPanel Lab4;

    public Lab4() {
        setTitle("Никольский В.А. | Лабораторная работа 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        makeLab1GUI();
        makeLab2GUI();

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

        tabbedPane.addTab("Слово", wordPanel);
        tabbedPane.addTab("Матрица", matrixPanel);

        add(tabbedPane);
    }

    private void makeLab1GUI() {
        // Вкладка 1: Бесконечные ряды, таблица функции

        GridLayout gridLab1 = new GridLayout(3, 3, 20, 10);
        JPanel infiniteRowsPanel = new JPanel(gridLab1);
        JTextArea resultLab1TextArea = new JTextArea();
        resultLab1TextArea.setEditable(false);

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
        tabbedPane.addTab("Лабораторная 1", infiniteRowsPanel);
    };

    private void makeLab2GUI() {
        // Вкладка 2: Вычисления для массивов

        GridLayout gridLab2 = new GridLayout(4, 1, 20, 10);
        JPanel lab2Panel = new JPanel(gridLab2);
        JTextArea resultLab2TextArea = new JTextArea();
        resultLab2TextArea.setEditable(false);

        JLabel inputLabel = new JLabel("Введите массив чисел через пробел:");
        inputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField inputArrayField = new JTextField();
        inputArrayField.setText("1.1 -2 3.5 4,643 -5.5 6 7");

        JButton calcPositivesMultiplicationButton = new JButton("Произведение положительных");
        calcPositivesMultiplicationButton.setMaximumSize(new Dimension(200, 50));
        JButton sumBeforeMinButton = new JButton("Сумма до минимального");

        ActionListener parseAndProcess = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double[] array = parseStringToDoubleArray(inputArrayField.getText());


                JButton source = (JButton) e.getSource();
                if (source == calcPositivesMultiplicationButton) {
                    String result = Lab2.ArrayCalcsLab2.get_positives_multiplication(array);
                    resultLab2TextArea.setText("Произведение положительных элементов: " + result);
                } else if (source == sumBeforeMinButton) {
                    String result = Lab2.ArrayCalcsLab2.sum_before_min_element(array);
                    resultLab2TextArea.setText("Сумма элементов до минимального: " + result);
                }
            }
        };

        calcPositivesMultiplicationButton.addActionListener(parseAndProcess);
        sumBeforeMinButton.addActionListener(parseAndProcess);

        lab2Panel.add(inputLabel);
        lab2Panel.add(inputArrayField);
        lab2Panel.add(calcPositivesMultiplicationButton);
        lab2Panel.add(sumBeforeMinButton);

        JScrollPane scrollPane = new JScrollPane(resultLab2TextArea);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        lab2Panel.add(scrollPane);

        tabbedPane.addTab("Лабораторная 2", lab2Panel);
    }

    private double[] parseStringToDoubleArray(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new double[0]; // возвращаем пустой массив
        }

        // Удаляем пробелы в начале и конце
        String trimmed = input.trim();

        // Разделяем строку по запятым
        String[] parts = trimmed.split(" ");

        // Создаем массив для результата
        double[] result = new double[parts.length];

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();

            part = part.replace(',', '.');

            try {
                result[i] = Double.parseDouble(part);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        String.format("Неверный формат числа '%s' на позиции %d", parts[i], i + 1), e);
            }
        }

        return result;
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