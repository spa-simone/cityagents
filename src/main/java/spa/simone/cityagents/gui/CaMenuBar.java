/**
 * City Agents is a framework for intelligent mobile agents.
 * Copyright (C) 2011 Deep Blue Team
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spa.simone.cityagents.gui;

import spa.simone.cityagents.gui.listeners.*;

import javax.swing.*;

import static spa.simone.cityagents.gui.util.Labels.*;

/**
 * @author Deep Blue Team
 */
public class CaMenuBar extends JMenuBar {

    private static final long serialVersionUID = -3591968585365805316L;

    private JMenu file;
    private JMenuItem loadMap;
    private JMenuItem storeMap;
    private JMenuItem exit;

    private JMenu world;
    private JMenuItem increaseDimension;
    private JMenuItem decreaseDimension;

    private JMenu agent;
    private JMenuItem addNewAgent;
    private JMenuItem addRandomAgent;

    private JMenu help;
    private JMenuItem about;

    /**
     *
     */
    public CaMenuBar() {
        super();
        setFileMenu();
        setWorldMenu();
        setAgentMenu();
        setHelpMenu();
    }

    private void setFileMenu() {
        file = new JMenu(FILE);

        loadMap = new JMenuItem(LOAD_MAP);
        loadMap.addActionListener(new LoadMapListener());
        storeMap = new JMenuItem(STORE_MAP);
        storeMap.addActionListener(new StoreMapListener());
        exit = new JMenuItem(EXIT);
        exit.addActionListener(new ExitListener());

        file.add(loadMap);
        file.add(storeMap);
        file.add(new JSeparator());
        file.add(exit);

        add(file);
    }

    private void setWorldMenu() {
        world = new JMenu(WORLD);

        increaseDimension = new JMenuItem(INCREASE_DIMENSION);
        increaseDimension.addActionListener(new IncreaseDimensionListener());
        decreaseDimension = new JMenuItem(DECREASE_DIMENSION);
        decreaseDimension.addActionListener(new DecreaseDimensionListener());

        world.add(increaseDimension);
        world.add(decreaseDimension);
        world.add(new JSeparator());

        add(world);
    }

    private void setAgentMenu() {
        agent = new JMenu(AGENT);

        addNewAgent = new JMenuItem(ADD_NEW);
        addNewAgent.addActionListener(new AddAgentActionListener());
        addNewAgent.setEnabled(false);
        addRandomAgent = new JMenuItem(ADD_RANDOM);
        addRandomAgent.addActionListener(new AddAgentsRandomlyActionListener());
        agent.add(addNewAgent);
        agent.add(addRandomAgent);

        add(agent);
    }

    private void setHelpMenu() {
        help = new JMenu(HELP);

        about = new JMenuItem(ABOUT);
        help.add(about);

        add(help);
    }

    public void disableMenu() {
        addNewAgent.setEnabled(true);
        increaseDimension.setEnabled(false);
        decreaseDimension.setEnabled(false);
        addRandomAgent.setEnabled(false);
        loadMap.setEnabled(false);
    }

}
