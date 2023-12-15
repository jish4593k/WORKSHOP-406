import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerGame {
    private GameWindow gui;
    private String fieldSize;
    private int ships4, ships3, ships2, ships1;

    public PlayerGame(GameWindow gui, String fieldSize, int ships4, int ships3, int ships2, int ships1) {
        this.gui = gui;
        this.fieldSize = fieldSize;
        this.ships4 = ships4;
        this.ships3 = ships3;
        this.ships2 = ships2;
        this.ships1 = ships1;
        createPlacementWindow();
    }

    private void createPlacementWindow() {
        JFrame placementWindow = new JFrame();
        placementWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placementWindow.setSize(getFieldSize() * 50 + 200, getFieldSize() * 50 + 50);
        placementWindow.setResizable(false);
        placementWindow.setVisible(true);

        String[] letters = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К", "Л"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

        JPanel fieldPanel = new JPanel(new GridLayout(getFieldSize() + 1, getFieldSize() + 1));
        JLabel fieldLabel = new JLabel("Игрок 1, расставьте ваши корабли");
        fieldLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
        fieldPanel.add(fieldLabel);

        for (int k = 0; k < getFieldSize(); k++) {
            JLabel numberLabel = new JLabel(numbers[k]);
            fieldPanel.add(numberLabel);
            JLabel letterLabel = new JLabel(letters[k]);
            fieldPanel.add(letterLabel);
        }

        List<JButton> fieldButtons = new ArrayList<>();
        for (int i = 0; i < getFieldSize(); i++) {
            for (int j = 0; j < getFieldSize(); j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                fieldPanel.add(button);
                fieldButtons.add(button);
            }
        }

        placementWindow.add(fieldPanel);
    }

    public int getFieldSize() {
        return Integer.parseInt(fieldSize.split(" ")[0]);
    }

    public static void main(String[] args) {
        // Assuming you have a GameWindow class
        GameWindow gui = new GameWindow();
        PlayerGame playerGame = new PlayerGame(gui, "11x11", 1, 2, 3, 4);
    }
}
