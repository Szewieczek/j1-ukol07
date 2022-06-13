package cz.czechitas.ukol7.view;

import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static cz.czechitas.ukol7.Barva.*;

public class HlavniOkno extends JFrame {
    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Preference");
        this.controller = controller;
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right, 100]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));


    FormBuilderWithContainer<PreferenceBean> formBuilder = FormBuilder.create(controller.getModel())
            .container(this);

    formBuilder
            .label("&Přezdívka")
            .textField("prezdivka")
            .add("span");

    formBuilder
            .label("&Oblíbená barva")
            .radioButton("Žlutá", "barva", Zluta)
            .add();
    formBuilder
            .radioButton("Zelená", "barva", Zelena)
            .add();
    formBuilder
            .radioButton("Červená", "barva", Cervena)
            .add();
    formBuilder
            .radioButton("Modrá", "barva", Modra)
            .add();
    formBuilder
            .radioButton("Oranžová", "barva", Oranzova)
            .add();
    formBuilder
            .radioButton("Fiaolvá", "barva", Fialova)
            .add();
    formBuilder
            .radioButton("Růžová", "barva", Ruzova)
            .add();
    formBuilder
            .radioButton("Hnědá", "barva", Hneda)
            .add();
    formBuilder
            .radioButton("Černá", "barva", Cerna)
            .add();
    formBuilder
            .radioButton("Bílá", "barva", Bila)
            .add();
    formBuilder
            .panel(panel -> {
                JButton ulozitButton = new JButton(controller.getUlozitAction());

                panel.add(ulozitButton);
                })
                .add("right, span");

    pack();
    }
}
