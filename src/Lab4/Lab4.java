package Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Lab4 extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel Lab4;

    public Lab4() {
        setTitle("Никольский В.А. | Лабораторная работа 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        // Рисуем GUI
        makeLab1GUI();
        makeLab2GUI();
        makeLab3GUI();
        add(tabbedPane);
    }

    private void makeLab1GUI() {
        // Вкладка 1: Бесконечные ряды, таблица функции

        // Создание компонентов
        GridLayout gridLab1 = new GridLayout(3, 3, 20, 10);
        JPanel infiniteRowsPanel = new JPanel(gridLab1);
        JTextArea resultLab1TextArea = new JTextArea();
        JButton calcInfiniteRowsButton = new JButton("Вычислить ");
        calcInfiniteRowsButton.setMaximumSize(new Dimension(200, 50));
        JButton calcTabulationButton = new JButton("Обработать массивы");

        // Доп. настройка компонентов
        resultLab1TextArea.setEditable(false);

        // Навешиваем слушатели событий
        calcInfiniteRowsButton.addActionListener(_ -> resultLab1TextArea.setText(Lab1.TabulatorLab1.calc()));
        calcTabulationButton.addActionListener(_ -> resultLab1TextArea.setText(Lab1.InfiniteRowLab1.calc()));

        // Добавление компонентов на форму
        infiniteRowsPanel.add(calcInfiniteRowsButton);
        infiniteRowsPanel.add(calcTabulationButton);
        infiniteRowsPanel.add(resultLab1TextArea);

        tabbedPane.addTab("Лабораторная 1", infiniteRowsPanel);
    }

    private void makeLab2GUI() {
        // Вкладка 2: Вычисления для массивов

        // Создание компонентов
        GridLayout gridLab2 = new GridLayout(4, 1, 20, 10);
        JPanel lab2Panel = new JPanel(gridLab2);
        JTextArea resultLab2TextArea = new JTextArea();
        JLabel inputLabel = new JLabel("Введите массив чисел через пробел:");
        JTextField inputArrayField = new JTextField();
        JButton calcPositivesMultiplicationButton = new JButton("Произведение положительных");
        JButton sumBeforeMinButton = new JButton("Сумма до минимального");
        JScrollPane scrollPane = new JScrollPane(resultLab2TextArea);

        // Донастройка компонентов
        resultLab2TextArea.setEditable(false);
        inputLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        inputArrayField.setText("1.1 -2 3.5 4,643 -5.5 6 7");
        calcPositivesMultiplicationButton.setMaximumSize(new Dimension(200, 50));
        scrollPane.setPreferredSize(new Dimension(400, 150));

        // Слушатель событий для кнопок
        ActionListener parseAndProcess = e -> {
            double[] array = parseStringToDoubleArray(inputArrayField.getText());

            JButton source = (JButton) e.getSource();
            if (source == calcPositivesMultiplicationButton) {
                String result = Lab2.ArrayCalcsLab2.get_positives_multiplication(array);
                resultLab2TextArea.setText("Произведение положительных элементов: " + result);
            } else if (source == sumBeforeMinButton) {
                String result = Lab2.ArrayCalcsLab2.sum_before_min_element(array);
                resultLab2TextArea.setText("Сумма элементов до минимального: " + result);
            }
        };

        // Вешаем слушатели событий
        calcPositivesMultiplicationButton.addActionListener(parseAndProcess);
        sumBeforeMinButton.addActionListener(parseAndProcess);

        // Добавляем компоненты на форму
        lab2Panel.add(inputLabel);
        lab2Panel.add(inputArrayField);
        lab2Panel.add(calcPositivesMultiplicationButton);
        lab2Panel.add(sumBeforeMinButton);
        lab2Panel.add(scrollPane);
        tabbedPane.addTab("Лабораторная 2", lab2Panel);
    }

    private void makeLab3GUI() {
        // Вкладка 3: Лабораторная работа 3 - Работа с матрицами

        // Создаем компоненты
        GridLayout gridLab3 = new GridLayout(3, 3, 20, 10);
        JPanel lab3Panel = new JPanel(gridLab3);
        JTextArea resultLab3TextArea = new JTextArea();
        JTextArea matrixInputArea = new JTextArea();
        JScrollPane matrixScrollPane = new JScrollPane(matrixInputArea);
        JScrollPane resultScrollPane = new JScrollPane(resultLab3TextArea);
        JButton countNegativeButton = new JButton("Отрицательные в нулевых строках");
        JButton maxAverageButton = new JButton("Максимальное среднее в столбцах");
        JLabel matrixLabel = new JLabel("Введите матрицу:");

        // Настраиваем компоненты
        matrixInputArea.setLineWrap(true);
        matrixInputArea.setText("1 2 0 -4\n4 2 3 1");
        matrixInputArea.setWrapStyleWord(true);
        resultLab3TextArea.setEditable(false);
        resultScrollPane.setPreferredSize(new Dimension(400, 250));
        countNegativeButton.setMaximumSize(new Dimension(200, 50));

        // Слушатель событий для кнопок
        ActionListener parseAndProcessMatrix = e -> {
            try {
                String matrixText = matrixInputArea.getText().trim();

                if (matrixText.isEmpty()) {
                    resultLab3TextArea.setText("Ошибка: Введите матрицу в текстовое поле");
                    return;
                }

                // Разбиваем на строки
                String[] lines = matrixText.split("\n");

                // Определяем количество строк и столбцов
                int rows = lines.length;
                if (rows == 0) {
                    resultLab3TextArea.setText("Ошибка: Матрица не содержит строк");
                    return;
                }

                // Определяем количество столбцов по первой строке
                String[] firstRowElements = lines[0].trim().split("\\s+");
                int cols = firstRowElements.length;

                // Проверяем, что все строки имеют одинаковое количество элементов
                for (int i = 0; i < rows; i++) {
                    String[] elements = lines[i].trim().split("\\s+");
                    if (elements.length != cols) {
                        resultLab3TextArea.setText(String.format(
                                """
                                        Ошибка: Несоответствие количества элементов
                                        Строка 1: %d элементов, Строка %d: %d элементов
                                        Все строки матрицы должны иметь одинаковое количество элементов""",
                                cols, i + 1, elements.length));
                        return;
                    }
                }

                // Парсим матрицу
                int[][] matrix = new int[rows][cols];
                StringBuilder errors = new StringBuilder();

                for (int i = 0; i < rows; i++) {
                    String[] elements = lines[i].trim().split("\\s+");
                    for (int j = 0; j < cols; j++) {
                        try {
                            matrix[i][j] = Integer.parseInt(elements[j]);
                        } catch (NumberFormatException ex) {
                            errors.append(String.format(
                                    "Строка %d, столбец %d: '%s' не является целым числом\n",
                                    i + 1, j + 1, elements[j]));
                        }
                    }
                }

                // Если есть ошибки парсинга
                if (!errors.isEmpty()) {
                    resultLab3TextArea.setText("Ошибки при парсинге матрицы:\n" + errors +
                            "\nВсе элементы матрицы должны быть целыми числами");
                    return;
                }

                // Выполняем нужную операцию
                if (e.getSource() == countNegativeButton) {
                    String result = Lab3.MatrixLab3.count_negative_in_zero_rows(matrix);

                    // Форматируем вывод матрицы
                    StringBuilder matrixOutput = new StringBuilder();
                    matrixOutput.append("Матрица ").append(rows).append("x").append(cols).append(":\n");

                    // Определяем максимальную длину числа для выравнивания
                    int maxLength = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            int length = String.valueOf(matrix[i][j]).length();
                            if (length > maxLength) maxLength = length;
                        }
                    }

                    // Выводим матрицу
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrixOutput.append(String.format("%" + (maxLength + 2) + "d", matrix[i][j]));
                        }
                        matrixOutput.append("\n");
                    }

                    resultLab3TextArea.setText(matrixOutput +
                            "\nКоличество отрицательных элементов в строках, содержащих ноль: " + result);

                } else if (e.getSource() == maxAverageButton) {
                    String result = Lab3.MatrixLab3.max_average_in_columns(matrix);

                    // Форматируем вывод матрицы
                    StringBuilder matrixOutput = new StringBuilder();
                    matrixOutput.append("Матрица ").append(rows).append("x").append(cols).append(":\n");

                    // Определяем максимальную длину числа для выравнивания
                    int maxLength = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            int length = String.valueOf(matrix[i][j]).length();
                            if (length > maxLength) maxLength = length;
                        }
                    }

                    // Выводим матрицу
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrixOutput.append(String.format("%" + (maxLength + 2) + "d", matrix[i][j]));
                        }
                        matrixOutput.append("\n");
                    }

                    resultLab3TextArea.setText(matrixOutput + "\nМаксимальное среднее арифметическое среди столбцов: " + result);
                }

            } catch (Exception ex) {
                resultLab3TextArea.setText("Ошибка: " + ex.getMessage() +
                        "\n\nФормат ввода матрицы:\n" +
                        "• Элементы в строке разделяйте пробелами\n" +
                        "• Каждая строка матрицы - с новой строки\n" +
                        "• Все элементы должны быть целыми числами\n\n" +
                        "Пример матрицы 3x4:\n" +
                        "1 2 -3 0\n" +
                        "-5 0 7 8\n" +
                        "9 10 -11 12");
            }
        };

        // Вешаем слушатели событий
        countNegativeButton.addActionListener(parseAndProcessMatrix);
        maxAverageButton.addActionListener(parseAndProcessMatrix);

        // Добавляем компоненты на форму
        lab3Panel.add(matrixLabel);
        lab3Panel.add(matrixScrollPane);
        lab3Panel.add(countNegativeButton);
        lab3Panel.add(maxAverageButton);
        lab3Panel.add(resultScrollPane);
        tabbedPane.addTab("Лабораторная 3", lab3Panel);
    }

    private double[] parseStringToDoubleArray(String input) {
        // Конвертер из строки в массив вещественных чисел

        if (input == null || input.trim().isEmpty()) {
            return new double[0];
        }

        String trimmed = input.trim();
        String[] parts = trimmed.split(" ");

        double[] res = new double[parts.length];

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();

            part = part.replace(',', '.');

            try {
                res[i] = Double.parseDouble(part);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        String.format("Неверный формат числа '%s' на позиции %d", parts[i], i + 1), e);
            }
        }

        return res;
    }

    public static void main() {
        SwingUtilities.invokeLater(() -> {
            Lab4 lab4 = new Lab4();
            lab4.setVisible(true);
        });
    }
}