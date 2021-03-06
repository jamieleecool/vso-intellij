// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the project root.

package com.microsoft.alm.plugin.idea.setup;

import com.intellij.openapi.components.ApplicationComponent;
import com.microsoft.alm.plugin.idea.services.CredentialsPromptImpl;
import com.microsoft.alm.plugin.idea.services.ServerContextStoreImpl;
import com.microsoft.alm.plugin.idea.services.TelemetryContextInitializer;
import com.microsoft.alm.plugin.services.PluginServiceProvider;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Initializes and configures plugin at startup
 */
public class ApplicationStartup implements ApplicationComponent {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);
    private static final String OS_NAME = "os.name";
    private static final String WINDOWS = "windows";

    public ApplicationStartup() {
    }

    public void initComponent() {
        // Setup the services that the core plugin components need
        PluginServiceProvider.getInstance().initialize(
                new ServerContextStoreImpl(),
                new CredentialsPromptImpl(),
                new TelemetryContextInitializer(),
                true);

        doOsSetup();
    }

    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "ApplicationStartup";
    }

    /**
     * Finds the OS type the plugin is running on and calls the setup for it
     */
    protected void doOsSetup() {
        final String osName = System.getProperty(OS_NAME).toLowerCase();
        if (osName.startsWith(WINDOWS)) {
            logger.debug("Windows operating system detected");
            // WindowsStartup.startup(); TODO: comment back in once arguments are being passed
        } else {
            //TODO: Add mac and linux logic
        }
    }
}