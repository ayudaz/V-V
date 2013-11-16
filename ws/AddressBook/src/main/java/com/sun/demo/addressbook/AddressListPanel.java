/*
 * AddressListPanel.java
 * 
 * Copyright 2006 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html .
 *
 */

package com.sun.demo.addressbook;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author  John O'Conner
 */
public class AddressListPanel extends javax.swing.JPanel {
    
    /**
	 * Generated serial id.
	 */
	private static final long serialVersionUID = 8248313070932798116L;
	
	
	
	/** Creates new form AddressListPanel */
    public AddressListPanel() {
        renderer = new ListEntryRenderer();
        model = new DefaultListModel<ListEntry>();
        initComponents();
        
        
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        scrollPane = new javax.swing.JScrollPane();
        addressList = new javax.swing.JList<ListEntry>();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBar(null);
        scrollPane.setViewport(null);
        addressList.setModel(model);
        addressList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        addressList.setCellRenderer(renderer);
        scrollPane.setViewportView(addressList);

        add(scrollPane);

    }// </editor-fold>//GEN-END:initComponents
    
    public void addListEntry(ListEntry entry) {
        model.addElement(entry);
        
    }
    
    public void addListEntries(List<ListEntry> list) {
        for(ListEntry entry: list) { 
            addListEntry(entry);
        }
    }
    
    public int getSelectedIndex() {
        return addressList.getSelectedIndex();
    }
    
    public int setSelectedIndex(int index) {
        assert(index >= -1);
        DefaultListModel<ListEntry> model = (DefaultListModel<ListEntry>)addressList.getModel();
        int size = model.getSize();
        if (index < size) {
            addressList.setSelectedIndex(index);
        } else {
            addressList.setSelectedIndex(size-1);
            index = size -1;
        }
        return index;
    }
    
    public ListEntry getSelectedListEntry() {
        ListEntry entry = addressList.getSelectedValue();
        return entry;
    }
    
    public int deleteSelectedEntry() {
        int selectedIndex = addressList.getSelectedIndex();
        if (selectedIndex >= 0) {
            DefaultListModel<ListEntry> model = (DefaultListModel<ListEntry>)addressList.getModel();
            model.remove(selectedIndex);
        }
        return selectedIndex;
    }
    public void addListSelectionListener(ListSelectionListener listener) {
        addressList.addListSelectionListener(listener);
    }
    
    public void removeListSelectionListener(ListSelectionListener listener) {
        addressList.removeListSelectionListener(listener);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<ListEntry> addressList;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    
    private ListEntryRenderer renderer;
    private DefaultListModel<ListEntry> model;
}