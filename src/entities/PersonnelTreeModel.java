/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import db.connection.OfficeDAO;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author HUNGUYEN
 */
public class PersonnelTreeModel {

    private static final OfficeDAO oDAO = new OfficeDAO();
    private static final URL urlRoot = ClassLoader.getSystemResource("icon/office.png");
    private static final URL urlMaleLeaf = ClassLoader.getSystemResource("icon/Male.png");
    private static final URL urlFemaleLeaf = ClassLoader.getSystemResource("icon/Female.png");
    private static final Toolkit tk = Toolkit.getDefaultToolkit();

    private static final Image imageRoot = tk.getImage(urlRoot);
    private static final Image imageMaleLeaf = tk.getImage(urlMaleLeaf);
    private static final Image imageFemaleLeaf = tk.getImage(urlFemaleLeaf);

    private static final Icon rootIcon = new ImageIcon(imageRoot);
    private static final Icon maleIcon = new ImageIcon(imageMaleLeaf);
    private static final Icon femaleIcon = new ImageIcon(imageFemaleLeaf);

    public static DefaultTreeModel buildTreeModel(String rootNode, ArrayList<Office> nameList) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootNode);

        int officeNum = nameList.size();

        for (int i = 0; i < officeNum; i++) {
            String officeName = nameList.get(i).getOfficeName();
            DefaultMutableTreeNode officeNode = new DefaultMutableTreeNode(officeName);

            short officeID = nameList.get(i).getOfficeID();
            ArrayList<NameAndSex> nam = oDAO.loadPersonnel(officeID);
            nam.stream().forEach((nam1) -> {
                officeNode.add(new DefaultMutableTreeNode(nam1));
            });
            root.add(officeNode);
        }

        return new DefaultTreeModel(root);
    }

    public static void setPersonnelTree(JTree tree) {

        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                    Object value, boolean selected, boolean expanded,
                    boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                        selected, expanded, isLeaf, row, focused);
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                Object objNode = node.getUserObject();
                if (!(objNode instanceof NameAndSex)) {
                    setIcon(rootIcon);
                } else {
                    NameAndSex n = (NameAndSex) objNode;
                    if (n.getSex() == (short) 1) {
                        setIcon(maleIcon);
                    } else {
                        setIcon(femaleIcon);

                    }
                }
                return c;
            }
        }
        );
    }

}
