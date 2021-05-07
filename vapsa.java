import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vapsa {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 500;
        final int FRAME_HEIGHT = 200;
    
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("VAPSA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            frame.setIconImage(ImageIO.read(new File("colorful-2174045_640.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel commandPanel = new JPanel();
        JRadioButton perimeterButton = new JRadioButton("Perimeter");
        perimeterButton.setSelected(true);
        JRadioButton areaButton = new JRadioButton("Area");
        JRadioButton volumeButton = new JRadioButton("Volume");
        JRadioButton surfaceareaButton = new JRadioButton("Surface Area");
        ButtonGroup groupRadio = new ButtonGroup();

        groupRadio.add(perimeterButton);
        groupRadio.add(areaButton);
        groupRadio.add(volumeButton);
        groupRadio.add(surfaceareaButton);
        commandPanel.add(perimeterButton);
        commandPanel.add(areaButton);
        commandPanel.add(volumeButton);
        commandPanel.add(surfaceareaButton);
        commandPanel.setBorder(new TitledBorder(new EtchedBorder(Color.ORANGE, Color.DARK_GRAY), "Command"));

        frame.setLayout(new BorderLayout());
        frame.add(commandPanel, BorderLayout.NORTH);

        JPanel commandPanel2 = new JPanel();
        JComboBox<String> shapeBox = new JComboBox<String>();
        shapeBox.addItem("Triangle");
        shapeBox.addItem("Square");
        shapeBox.addItem("Rectangle");
        shapeBox.addItem("Pentagon");
        shapeBox.addItem("Hexagon");
        shapeBox.addItem("Heptagon");
        shapeBox.addItem("Octagon");
        shapeBox.addItem("Sphere");
        shapeBox.addItem("Cylinder");
        shapeBox.addItem("Cube");
        shapeBox.addItem("Rectangular Prism");
        shapeBox.addItem("Cone");
        shapeBox.addItem("Square Pyramid");
        shapeBox.addItem("Triangular Prism");
        commandPanel2.add(shapeBox);
        commandPanel2.setBorder(new TitledBorder(new EtchedBorder(Color.ORANGE, Color.DARK_GRAY), "Shape"));

        frame.add(commandPanel2, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        JButton caculateButton = new JButton("Calculate");
        caculateButton.setBorder(new TitledBorder(new EtchedBorder(Color.ORANGE, Color.DARK_GRAY)));
        caculateButton.setPreferredSize(new Dimension(25, 35));
        caculateButton.setBackground(new Color(234,182,118));

        JLabel empty = new JLabel();
        JLabel empty2 = new JLabel();
        buttonPanel.add(empty);
        buttonPanel.add(caculateButton);
        buttonPanel.add(empty2);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        caculateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (perimeterButton.isSelected())
                {
                    int max = 0;
                    int multiplier = 1;
                    switch ((String) shapeBox.getSelectedItem()){
                        case "Triangle":
                            max = 3;
                            break;
                        case "Square":
                            max = 1;
                            multiplier = 4;
                            break;
                        case "Rectangle":
                            max = 2;
                            multiplier = 2;
                            break;
                        case "Pentagon":
                            max = 1;
                            multiplier = 5;
                            break;
                        case "Hexagon":
                            max = 1;
                            multiplier = 6;
                            break;
                        case "Heptagon":
                            max = 1;
                            multiplier = 7;
                            break;
                        case "Octagon":
                            max = 1; 
                            multiplier = 8;
                            break;
                        default:
                            max = -1;

                    }

                    Double total = 0.0;
                    JFrame mssgBox = new JFrame();
                    for (int i = 0; i < max; i++)
                    {
                        String input = JOptionPane.showInputDialog(mssgBox, "Enter Side " + (i + 1), "Dimensions", JOptionPane.QUESTION_MESSAGE);
                        total += Double.parseDouble(input);
                    }
                    total = total * multiplier;
                    if (max == -1)
                    {
                        JOptionPane.showMessageDialog(mssgBox, "Combination does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(mssgBox, "Perimeter = " + total + " units", "Answer", JOptionPane.INFORMATION_MESSAGE);
                    }
                    max = 0;
                }
                else if (areaButton.isSelected())
                {
                    JFrame mssgBox = new JFrame();
                    switch ((String) shapeBox.getSelectedItem()){
                        case "Triangle":
                            String base = JOptionPane.showInputDialog(mssgBox, "Enter Base", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String height = JOptionPane.showInputDialog(mssgBox, "Enter Height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaTri = (Double.parseDouble(base) * Double.parseDouble(height)) / 2;
                            areaTri = Math.round(areaTri * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaTri + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Square":
                            String sideLength = JOptionPane.showInputDialog(mssgBox, "Enter side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaSq = Math.pow(Double.parseDouble(sideLength), 2);
                            areaSq = Math.round(areaSq * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaSq + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Rectangle":
                            String length = JOptionPane.showInputDialog(mssgBox, "Enter length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String width = JOptionPane.showInputDialog(mssgBox, "Enter width", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaRect = (Double.parseDouble(length)) * (Double.parseDouble(width));
                            areaRect = Math.round(areaRect * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaRect + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Pentagon":
                            String sidePent = JOptionPane.showInputDialog(mssgBox, "Enter a side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaPent = (Math.sqrt(5 * (5 + (2 * Math.sqrt(5)))) / 4) * (Math.pow(Double.parseDouble(sidePent), 2));
                            areaPent = Math.round(areaPent * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaPent + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Hexagon":
                            String sideHex = JOptionPane.showInputDialog(mssgBox, "Enter a side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaHex = ((3 * Math.sqrt(3)) / 2) * (Math.pow(Double.parseDouble(sideHex), 2));
                            areaHex = Math.round(areaHex * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaHex + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Heptagon":
                            Double coTan = 1.0 / Math.tan(Math.toRadians(180.0 / 7.0));
                            String sideHept = JOptionPane.showInputDialog(mssgBox, "Enter a side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaHept = (7.0/4.0) * (Math.pow(Double.parseDouble(sideHept), 2)) * coTan;
                            areaHept = Math.round(areaHept * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaHept + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Octagon":
                            String sideOct = JOptionPane.showInputDialog(mssgBox, "Enter a side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double areaOct = 2 * (1 + Math.sqrt(2)) * (Math.pow(Double.parseDouble(sideOct), 2));
                            areaOct = Math.round(areaOct * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Area = " + areaOct + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(mssgBox, "Combination does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }        
                }
                else if (volumeButton.isSelected())
                {
                    JFrame mssgBox = new JFrame();
                    switch ((String) shapeBox.getSelectedItem()){
                        case "Sphere": 
                            String radius = JOptionPane.showInputDialog(mssgBox, "Enter radius", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double sphereVol = (4.0/3.0) * (Math.PI) * (Math.pow(Double.parseDouble(radius), 3));
                            sphereVol = Math.round(sphereVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + sphereVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Cylinder":
                            String radiusCyl = JOptionPane.showInputDialog(mssgBox, "Enter radius", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightCyl = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double cylVol = (Math.PI) * (Math.pow(Double.parseDouble(radiusCyl), 2)) * (Double.parseDouble(heightCyl));
                            cylVol = Math.round(cylVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + cylVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Cube":
                            String cubeSide = JOptionPane.showInputDialog(mssgBox, "Enter side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double cubeVol = Math.pow(Double.parseDouble(cubeSide), 3);
                            cubeVol = Math.round(cubeVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + cubeVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Rectangular Prism":
                            String lengthRect = JOptionPane.showInputDialog(mssgBox, "Enter length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String widthRect = JOptionPane.showInputDialog(mssgBox, "Enter width", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightRect = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double rectPriVol = (Double.parseDouble(lengthRect)) * (Double.parseDouble(widthRect)) * (Double.parseDouble(heightRect));
                            rectPriVol = Math.round(rectPriVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + rectPriVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Cone":
                            String radiusCone = JOptionPane.showInputDialog(mssgBox, "Enter radius", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightCone = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double coneVol = (Math.PI) * (Math.pow(Double.parseDouble(radiusCone), 2)) * (Double.parseDouble(heightCone) / 3);
                            coneVol = Math.round(coneVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + coneVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Square Pyramid":
                            String baseEdge = JOptionPane.showInputDialog(mssgBox, "Enter base edge length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightSqPy = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double sqPyVol = (Math.pow(Double.parseDouble(baseEdge), 2)) * (Double.parseDouble(heightSqPy) / 3);
                            sqPyVol = Math.round(sqPyVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + sqPyVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Triangular Prism":
                            String baseSide1 = JOptionPane.showInputDialog(mssgBox, "Enter first base side", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String baseSide2 = JOptionPane.showInputDialog(mssgBox, "Enter second base side", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String baseSide3 = JOptionPane.showInputDialog(mssgBox, "Enter third base side", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightTriPri = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double triPriVol = (1.0/4.0) * (Double.parseDouble(heightTriPri)) * Math.sqrt((-1.0 * (Math.pow(Double.parseDouble(baseSide1), 4))) + (2.0 * Math.pow((Double.parseDouble(baseSide1) * Double.parseDouble(baseSide2)), 2)) + (2.0 * Math.pow((Double.parseDouble(baseSide1) * Double.parseDouble(baseSide3)), 2)) - (Math.pow(Double.parseDouble(baseSide2), 4)) + (2.0 * Math.pow((Double.parseDouble(baseSide2) * Double.parseDouble(baseSide3)), 2)) - (Math.pow(Double.parseDouble(baseSide3), 4))); 
                            triPriVol = Math.round(triPriVol * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Volume = " + triPriVol + " units cubed", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(mssgBox, "Combination does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (surfaceareaButton.isSelected())
                {
                    JFrame mssgBox = new JFrame();
                    switch ((String) shapeBox.getSelectedItem()){
                        case "Sphere": 
                            String radius = JOptionPane.showInputDialog(mssgBox, "Enter radius", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double sphereSa = (4.0) * (Math.PI) * (Math.pow(Double.parseDouble(radius), 2));
                            sphereSa = Math.round(sphereSa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + sphereSa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Cylinder":
                            String radiusCyl = JOptionPane.showInputDialog(mssgBox, "Enter radius", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightCyl = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double cylSa = ((2.0) * (Math.PI) * (Double.parseDouble(radiusCyl)) * (Double.parseDouble(heightCyl))) + ((2.0) * (Math.PI) * (Math.pow(Double.parseDouble(radiusCyl), 2)));
                            cylSa = Math.round(cylSa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + cylSa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Cube":
                            String cubeSide = JOptionPane.showInputDialog(mssgBox, "Enter side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double cubeSa = 6.0 * Math.pow(Double.parseDouble(cubeSide), 2);
                            cubeSa = Math.round(cubeSa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + cubeSa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Rectangular Prism":
                            String lengthRect = JOptionPane.showInputDialog(mssgBox, "Enter length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String widthRect = JOptionPane.showInputDialog(mssgBox, "Enter width", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightRect = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double rectPriSa = (2.0) * ((Double.parseDouble(widthRect) * Double.parseDouble(lengthRect)) + (Double.parseDouble(heightRect) * Double.parseDouble(lengthRect)) + (Double.parseDouble(heightRect) * Double.parseDouble(widthRect)));
                            rectPriSa = Math.round(rectPriSa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + rectPriSa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Cone":
                            String radiusCone = JOptionPane.showInputDialog(mssgBox, "Enter radius", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightCone = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double coneSa = (Math.PI) * (Double.parseDouble(radiusCone)) * (Double.parseDouble(radiusCone) + (Math.sqrt(Math.pow(Double.parseDouble(heightCone), 2) + Math.pow(Double.parseDouble(radiusCone), 2))));
                            coneSa = Math.round(coneSa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + coneSa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Square Pyramid":
                            String baseEdge = JOptionPane.showInputDialog(mssgBox, "Enter base edge length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightSqPy = JOptionPane.showInputDialog(mssgBox, "Enter height", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double sqPySa = Math.pow(Double.parseDouble(baseEdge), 2) + (2.0) * (Double.parseDouble(baseEdge)) * (Math.sqrt(((Math.pow(Double.parseDouble(baseEdge), 2) / 4)) + Math.pow(Double.parseDouble(heightSqPy), 2)));
                            sqPySa = Math.round(sqPySa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + sqPySa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Triangular Prism":
                            String baseSide1 = JOptionPane.showInputDialog(mssgBox, "Enter first triangle side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String baseSide2 = JOptionPane.showInputDialog(mssgBox, "Enter second triangle side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String baseSide3 = JOptionPane.showInputDialog(mssgBox, "Enter third triangle side length", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            String heightTriPri = JOptionPane.showInputDialog(mssgBox, "Enter height of prism", "Dimensions", JOptionPane.QUESTION_MESSAGE);
                            Double sVal = (Double.parseDouble(baseSide1) + Double.parseDouble(baseSide2) + Double.parseDouble(baseSide3)) /2.0;
                            Double triSa = Math.sqrt((sVal) * (sVal - Double.parseDouble(baseSide1) * (sVal - Double.parseDouble(baseSide2) * (sVal - Double.parseDouble(baseSide3)))));
                            Double triPriSa = (2.0 * triSa) + (Double.parseDouble(heightTriPri) * (Double.parseDouble(baseSide1) + Double.parseDouble(baseSide2) + Double.parseDouble(baseSide3)));
                            triPriSa = Math.round(triPriSa * 1000d) / 1000d;
                            JOptionPane.showMessageDialog(mssgBox, "Surface Area = " + triPriSa + " units squared", "Answer", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(mssgBox, "Combination does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }    
                }
            }
        });
    }
}
