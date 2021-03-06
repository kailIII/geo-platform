/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2015 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.gui.client.widget.form;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid.ClicksToEdit;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.common.collect.Lists;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.HasRpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.client.rpc.XsrfToken;
import com.google.gwt.user.client.rpc.XsrfTokenServiceAsync;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import org.geosdi.geoplatform.gui.client.ServerWidgetResources;
import org.geosdi.geoplatform.gui.client.i18n.ServerModuleConstants;
import org.geosdi.geoplatform.gui.client.i18n.ServerModuleMessages;
import org.geosdi.geoplatform.gui.client.i18n.buttons.ButtonsConstants;
import org.geosdi.geoplatform.gui.client.i18n.windows.WindowsConstants;
import org.geosdi.geoplatform.gui.client.widget.DisplayServerWidget;
import org.geosdi.geoplatform.gui.configuration.GPSecureStringTextField;
import org.geosdi.geoplatform.gui.client.widget.SearchStatus.EnumSearchStatus;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.geosdi.geoplatform.gui.global.security.GPAccountLogged;
import org.geosdi.geoplatform.gui.impl.view.LayoutManager;
import org.geosdi.geoplatform.gui.model.server.GPServerBeanModel;
import org.geosdi.geoplatform.gui.puregwt.oauth2.IGPOAuth2AddServerHandler;
import org.geosdi.geoplatform.gui.puregwt.oauth2.OAuth2HandlerManager;
import org.geosdi.geoplatform.gui.puregwt.oauth2.event.GPOAuth2GEBLoginEvent;
import org.geosdi.geoplatform.gui.service.gwt.xsrf.GPXsrfTokenService;
import org.geosdi.geoplatform.gui.service.server.GeoPlatformOGCRemote;
import org.geosdi.geoplatform.gui.service.server.GeoPlatformOGCRemoteAsync;
import org.geosdi.geoplatform.gui.utility.oauth2.EnumOAuth2;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class ManageServerWidget extends Window {

    private static final XsrfTokenServiceAsync xsrf = GPXsrfTokenService.Util.getInstance();
    private static final GeoPlatformOGCRemoteAsync geoPlatformOGCRemote = GeoPlatformOGCRemote.Util.getInstance();
    //
    private boolean initialized;
    private final PerformOperation operation = new PerformOperation();
    private ListStore<GPServerBeanModel> store = new ListStore<GPServerBeanModel>();
    private final Button deleteServerButton = new Button(
            ServerModuleConstants.INSTANCE.ManageServerWidget_deleteButtonText());
    private final DisplayServerWidget displayServerWidget;
    private GPCheckColumnConfig checkColumn;
    private StoreFilterField<GPServerBeanModel> serverFilter;

    public ManageServerWidget(DisplayServerWidget displayServerWidget,
            boolean lazy) {
        this.displayServerWidget = displayServerWidget;
        this.store = displayServerWidget.getStore();
        if (!lazy) {
            init();
        }
    }

    private Widget createServerFilter() {
        this.serverFilter = new StoreFilterField<GPServerBeanModel>() {

            @Override
            protected boolean doSelect(Store<GPServerBeanModel> store,
                    GPServerBeanModel parent,
                    GPServerBeanModel record, String property, String filter) {
                String serverAlias = record.getAlias().toString().toLowerCase();
                String serverURL = record.getUrlServer().toString().toLowerCase();
                if (serverAlias.contains(filter.toLowerCase()) || serverURL.contains(
                        filter.toLowerCase())) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        };
        serverFilter.setEmptyText(ServerModuleConstants.INSTANCE.
                ManageServerWidget_typeServerToSearchText());
        serverFilter.bind(this.store);
        serverFilter.setFieldLabel(ServerModuleConstants.INSTANCE.
                ManageServerWidget_serverFilterText());
        return this.serverFilter;
    }

    private void addComponentToForm() {
        super.setIcon(ServerWidgetResources.ICONS.addServer());
        super.setLayout(new FormLayout());
        List<ColumnConfig> configs = Lists.<ColumnConfig>newArrayList();

        ColumnConfig aliasColumn = new ColumnConfig();
        aliasColumn.setId("alias");
        aliasColumn.setHeaderHtml(ServerModuleConstants.INSTANCE.
                serverAliasText());
        aliasColumn.setWidth(220);

        GPSecureStringTextField aliasTextfield = new GPSecureStringTextField();
        aliasTextfield.setAllowBlank(false);
        aliasColumn.setEditor(new CellEditor(aliasTextfield));
        configs.add(aliasColumn);

        ColumnConfig urlColumn = new ColumnConfig();
        urlColumn.setId("urlServer");
        urlColumn.setHeaderHtml(ServerModuleConstants.INSTANCE.
                serverURLText());
        urlColumn.setWidth(400);

        GPSecureStringTextField urlTextfield = new GPSecureStringTextField();
        urlTextfield.setAllowBlank(false);
//        urlTextfield.setEmptyText("http://");
        urlColumn.setEditor(new CellEditor(urlTextfield));
        configs.add(urlColumn);

        checkColumn = new GPCheckColumnConfig("delete",
                ButtonsConstants.INSTANCE.deleteText(), 55, store,
                this.deleteServerButton);
        CellEditor checkBoxEditor = new CellEditor(new CheckBox());
        checkColumn.setEditor(checkBoxEditor);
        //This is very important: add checkColumn to the zero position!
        configs.add(0, checkColumn);
        final ColumnModel columnModel = new ColumnModel(configs);
        final Grid<GPServerBeanModel> grid = new Grid<GPServerBeanModel>(store,
                columnModel);
        RowEditor<GPServerBeanModel> rowEditor = new RowEditor<GPServerBeanModel>() {

            @Override
            protected void onEnter(ComponentEvent ce) {
                System.out.println("Selected null: ");
                System.out.println(grid.getSelectionModel().getSelectedItem());
                Record record = store.getRecord(
                        grid.getSelectionModel().getSelectedItem());
                record.reject(true);
                super.onEnter(ce);
            }

            @Override
            protected void onHide() {
                super.onHide();
                //System.out.println("Hiding row editor and verifing the check status");
                checkColumn.manageDeleteButton();
            }
        };
        rowEditor.setClicksToEdit(ClicksToEdit.TWO);

        grid.setAutoExpandColumn("urlServer");
        grid.setBorders(true);
        grid.addPlugin(checkColumn);
        grid.addPlugin(rowEditor);
        grid.getAriaSupport().setLabelledBy(super.getHeader().getId() + "-label");
        grid.setHeight(200);
        super.add(grid);
        super.add(this.createServerFilter());
        this.addButtonsToTheWindow(rowEditor);
    }

    private void addButtonsToTheWindow(
            final RowEditor<GPServerBeanModel> rowEditor) {
        ToolBar toolBar = new ToolBar();
        Button addServerButton = new Button(ServerModuleConstants.INSTANCE.
                addServerText());
        addServerButton.addSelectionListener(
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        GPServerBeanModel server = new GPServerBeanModel();
//                server.setUrlServer("http://");
                        rowEditor.stopEditing(false);
                        store.insert(server, 0);
                        Record record = store.getRecord(server);
                        record.set("alias", ServerModuleConstants.INSTANCE.
                                ManageServerWidget_newServerText());
                        record.set("urlServer", "");
                        store.update(server);
                        rowEditor.startEditing(store.indexOf(server), true);
                    }
                });
        toolBar.add(addServerButton);
        deleteServerButton.setEnabled(false);
        deleteServerButton.addSelectionListener(
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        rowEditor.stopEditing(true);
                        List<GPServerBeanModel> serverList = store.getModels();
                        int i = 0;
                        for (GPServerBeanModel gPServerBeanModel : serverList) {

                            String check = checkColumn.getCheckState(
                                    gPServerBeanModel,
                                    "delete", i, 0);
                            if (check.equals("-on")) {
                                operation.deleteServer(gPServerBeanModel);
                            }
                            i++;
                        }
                        checkColumn.manageDeleteButton();
                    }
                });
        toolBar.add(deleteServerButton);
        super.setTopComponent(toolBar);
        super.setButtonAlign(HorizontalAlignment.RIGHT);
        super.addButton(new Button(ButtonsConstants.INSTANCE.resetText(),
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        rowEditor.stopEditing(true);
                        store.rejectChanges();
                        serverFilter.clear();
                        checkColumn.manageDeleteButton();
                    }
                }));
        super.addButton(new Button(ButtonsConstants.INSTANCE.saveText(),
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        rowEditor.stopEditing(true);
                        List<Record> modifiedElements = store.getModifiedRecords();
                        if (!modifiedElements.isEmpty()) {

                            operation.setModifiedElementsNumber(
                                    modifiedElements.size());

                            for (Record record : modifiedElements) {
                                operation.callSaveRecord(record);
                            }
                        }
                    }
                }));
    }

    @Override
    public void hide(Button buttonPressed) {
        if (store.getModifiedRecords().isEmpty()) {
            super.hide(buttonPressed);
            this.displayServerWidget.loadServers();
        } else {
            GeoPlatformMessage.alertMessage(
                    WindowsConstants.INSTANCE.warningTitleText(),
                    WindowsConstants.INSTANCE.unsavedChangesToSaveOrResetText());
        }
    }

    public void initSize() {
        super.setModal(true);
        super.setHeadingHtml(
                ServerModuleConstants.INSTANCE.ManageServerWidget_headingText());
        super.setBorders(false);
        super.setSize(600, 325);
    }

    @Override
    public void show() {
        if (!initialized) {
            this.init();
        }
        super.show();
//        this.loadServers();
    }

    private void init() {
        this.initSize();
        this.addComponentToForm();
        this.initialized = true;
    }

    /**
     * Internal Class for Business Logic
     *
     */
    private class PerformOperation implements IGPOAuth2AddServerHandler {

        private int modifiedElementsNumber;
        private Record record;

        public PerformOperation() {
            OAuth2HandlerManager.addHandler(IGPOAuth2AddServerHandler.TYPE, this);
        }

        private void callSaveRecord(Record theRecord) {
            record = theRecord;
            updateInsertServer();
        }

        private void deleteServer(final GPServerBeanModel server) {
            if (server.getId() != null) {
                xsrf.getNewXsrfToken(new AsyncCallback<XsrfToken>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        try {
                            throw caught;
                        } catch (RpcTokenException e) {
                            // Can be thrown for several reasons:
                            //   - duplicate session cookie, which may be a sign of a cookie
                            //     overwrite attack
                            //   - XSRF token cannot be generated because session cookie isn't
                            //     present
                        } catch (Throwable e) {
                            // unexpected
                        }
                    }

                    @Override
                    public void onSuccess(XsrfToken token) {
                        ((HasRpcToken) geoPlatformOGCRemote).setRpcToken(token);
                        geoPlatformOGCRemote.deleteServer(server.getId(),
                                new AsyncCallback<Boolean>() {

                                    @Override
                                    public void onFailure(Throwable caught) {
                                        GeoPlatformMessage.errorMessage(
                                                ServerModuleConstants.INSTANCE.ManageServerWidget_errorDeletingTitleText(),
                                                ServerModuleMessages.INSTANCE.ManageServerWidget_errorDeletingBodyMessage(
                                                        caught.getMessage(),
                                                        server.get(
                                                                "urlServer").toString()));
                                        LayoutManager.getInstance().getStatusMap().setStatus(
                                                ServerModuleMessages.INSTANCE.
                                                ManageServerWidget_deleteServerErrorMessage(
                                                        caught.getMessage()),
                                                EnumSearchStatus.STATUS_SEARCH_ERROR.toString());
                                    }

                                    @Override
                                    public void onSuccess(Boolean result) {
                                        store.remove(server);
                                        checkColumn.manageDeleteButton();
                                        LayoutManager.getInstance().getStatusMap().setStatus(
                                                ServerModuleConstants.INSTANCE.
                                                ManageServerWidget_statusServerDeletedSuccesfullyText(),
                                                EnumSearchStatus.STATUS_SEARCH.toString());
                                        //TODO: refresh the displayServerWidget
                                        //displayServerWidget.addServer(server);
                                    }
                                });
                    }
                });
            } else {
                store.remove(server);
            }
        }

        @Override
        public void updateInsertServer() {
            final GPServerBeanModel server = (GPServerBeanModel) record.getModel();
            xsrf.getNewXsrfToken(new AsyncCallback<XsrfToken>() {

                @Override
                public void onFailure(Throwable caught) {
                    try {
                        throw caught;
                    } catch (RpcTokenException e) {
                        // Can be thrown for several reasons:
                        //   - duplicate session cookie, which may be a sign of a cookie
                        //     overwrite attack
                        //   - XSRF token cannot be generated because session cookie isn't
                        //     present
                    } catch (Throwable e) {
                        // unexpected
                    }
                }

                @Override
                public void onSuccess(XsrfToken token) {
                    ((HasRpcToken) geoPlatformOGCRemote).setRpcToken(token);
                    geoPlatformOGCRemote.saveServer(server.getId(),
                            record.get("alias").toString(),
                            record.get("urlServer").toString().trim(),
                            GPAccountLogged.getInstance().getOrganization(),
                            new AsyncCallback<GPServerBeanModel>() {

                                @Override
                                public void onFailure(Throwable caught) {
                                    verifyEndOperation();
                                    if (server.getUrlServer().contains(
                                            EnumOAuth2.GEB_STRING.getValue())) {
                                        GeoPlatformMessage.infoMessage(
                                                ServerModuleConstants.INSTANCE.
                                                googleSignOnRequiredTitleText(),
                                                ServerModuleConstants.INSTANCE.
                                                googleSignOnRequiredBodyText());
                                        OAuth2HandlerManager.fireEvent(
                                                new GPOAuth2GEBLoginEvent(
                                                        EnumOAuth2.ADD_SERVER.getValue()));
                                    } else {
                                        GeoPlatformMessage.errorMessage(
                                                ServerModuleConstants.INSTANCE.
                                                ManageServerWidget_errorSavingTitleText(),
                                                caught.getMessage());
                                        LayoutManager.getInstance().getStatusMap().setStatus(
                                                ServerModuleMessages.INSTANCE.
                                                AddServerWidget_saveServerErrorMessage(
                                                        caught.getMessage()),
                                                EnumSearchStatus.STATUS_SEARCH_ERROR.toString());
                                    }
                                }

                                @Override
                                public void onSuccess(
                                        GPServerBeanModel serverSaved) {
                                            verifyEndOperation();
                                            store.remove(server);
                                            store.insert(serverSaved, 0);
                                            LayoutManager.getInstance().getStatusMap().setStatus(
                                                    ServerModuleConstants.INSTANCE.
                                                    ManageServerWidget_serverAddedSuccesfullyText(),
                                                    EnumSearchStatus.STATUS_SEARCH.toString());
                                        }
                            });
                }
            });
        }

        private void verifyEndOperation() {
            modifiedElementsNumber--;
            if (modifiedElementsNumber <= 0) {
                unmask();
            }
        }

        public int getModifiedElementsNumber() {
            return modifiedElementsNumber;
        }

        public void setModifiedElementsNumber(int modifiedElementsNumber) {
            this.modifiedElementsNumber = modifiedElementsNumber;
        }
    }
}
