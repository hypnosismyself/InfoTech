package Lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab4 extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private JPanel Lab4;

    public Lab4() {
        setTitle("Никольский В.А. | Лабораторная работа 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Рисуем GUI
        makeLab1GUI();
        makeLab2GUI();
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

        calcInfiniteRowsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLab1TextArea.setText(Lab1.TabulatorLab1.calc());
            }
        });

        calcTabulationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLab1TextArea.setText(Lab1.InfiniteRowLab1.calc());
            }
        });

        // Добавление компонентов на форму
        infiniteRowsPanel.add(calcInfiniteRowsButton);
        infiniteRowsPanel.add(calcTabulationButton);
        infiniteRowsPanel.add(resultLab1TextArea);

        tabbedPane.addTab("Лабораторная 1", infiniteRowsPanel);
    };

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

    private double[] parseStringToDoubleArray(String input) {
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Lab4 lab4 = new Lab4();
                lab4.setVisible(true);
            }
        });
    }
}