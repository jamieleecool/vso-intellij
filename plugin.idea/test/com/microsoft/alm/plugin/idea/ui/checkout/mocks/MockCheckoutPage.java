// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.idea.ui.checkout.mocks;

import com.microsoft.alm.plugin.idea.ui.checkout.CheckoutPage;

import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MockCheckoutPage implements CheckoutPage {
    private List<ActionListener> actionListeners = new ArrayList<ActionListener>();
    private String displayError;
    private int selectedTabIndex = 0;
    private boolean loginShowing = false;
    private boolean cloneEnabled = false;
    private String repositoryFilter;

    @Override
    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }

    @Override
    public void setLoginShowing(boolean showLogin) {
        loginShowing = showLogin;
    }

    @Override
    public void setLoading(boolean loading) {
    }

    @Override
    public void setAuthenticating(final boolean authenticating) {}

    @Override
    public void setRepositoryFilter(String filter) {
        repositoryFilter = filter;
    }

    @Override
    public String getRepositoryFilter() {
        return repositoryFilter;
    }

    @Override
    public void setRepositoryTable(TableModel tableModel, ListSelectionModel selectionModel) {

    }

    @Override
    public void setParentDirectory(String path) {

    }

    @Override
    public String getParentDirectory() {
        return null;
    }

    @Override
    public JComponent getComponent(String name) { return null; }

    @Override
    public void setDirectoryName(String name) {

    }

    @Override
    public String getDirectoryName() {
        return null;
    }

    @Override
    public void setUserName(String name) {

    }

    @Override
    public void setServerName(String name) {

    }

    @Override
    public String getServerName() {
        return null;
    }
}
