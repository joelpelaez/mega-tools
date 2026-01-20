/**
 * Mega Tools
 * Copyright (C) 2014-2025  Joe Max Solutions
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

package com.joemaxsolutions.mc.megatools;

import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class I18n {
    private static I18n instance;
    private static final String MESSAGES = "messages";
    private final Locale defaultLocale = Locale.getDefault();
    private Locale currentLocale = defaultLocale;
    private final ResourceBundle customBundle;
    private ResourceBundle localeBundle;
    private final ResourceBundle defaultBundle;
    private transient Map<String, MessageFormat> messageFormatCache = new HashMap<>();
    private static final Pattern NO_DOUBLE_MARK = Pattern.compile("''");
    private static final ResourceBundle NULL_BUNDLE = new ResourceBundle() {
        @Override
        public @NotNull Enumeration<String> getKeys() {
            return Collections.emptyEnumeration();
        }

        @Override
        protected Object handleGetObject(@NotNull String key) {
            return null;
        }
    };

    public I18n() {
        defaultBundle = ResourceBundle.getBundle(MESSAGES, Locale.ENGLISH);
        localeBundle = defaultBundle;
        customBundle = NULL_BUNDLE;
    }

    public void onEnable() {
        instance = this;
    }

    public void onDisable() {
        instance = null;
    }

    private String translate(final String string) {
        try {
            try {
                return customBundle.getString(string);
            } catch (MissingResourceException ex) {
                return localeBundle.getString(string);
            }
        } catch (MissingResourceException ex) {
            Logger.getLogger("MegaTools").log(Level.WARNING, String.format("Missing translation key \"%s\" in translation file %s", ex.getKey(), localeBundle.getLocale().toString()), ex);
            return defaultBundle.getString(string);
        }
    }

    public static String tl(final String string, final Object... objects) {
        if (instance == null) {
            return "";
        }
        if (objects.length == 0) {
            return NO_DOUBLE_MARK.matcher(instance.translate(string)).replaceAll("'");
        } else {
            return instance.format(string, objects);
        }
    }

    public String format(final String string, final Object... objects) {
        String format = translate(string);
        MessageFormat messageFormat = messageFormatCache.get(format);
        if (messageFormat == null) {
            try {
                messageFormat = new MessageFormat(format);
            } catch (IllegalArgumentException e) {
                Logger.getLogger("MegaTools").log(Level.SEVERE, "Invalid Translation key for '" + string + "': " + e.getMessage());
                format = format.replaceAll("\\{(\\D*?)}", "[$1]");
                messageFormat = new MessageFormat(format);
            }
            messageFormatCache.put(format, messageFormat);
        }
        return messageFormat.format(objects);
    }

    public void updateLocale(final String loc) {
        if (loc != null && !loc.isEmpty()) {
            final String[] parts = loc.split("[_.]");
            if (parts.length == 1) {
                currentLocale = Locale.of(parts[0]);
            }
            if (parts.length == 2) {
                currentLocale = Locale.of(parts[0], parts[1]);
            }
            if (parts.length == 3) {
                currentLocale = Locale.of(parts[0], parts[1], parts[2]);
            }
        }
        ResourceBundle.clearCache();
        messageFormatCache = new HashMap<>();
        Logger.getLogger("MegaTools").log(Level.INFO, String.format("Using locale %s", currentLocale.toString()));

        try {
            localeBundle = ResourceBundle.getBundle(MESSAGES, currentLocale);
        } catch (MissingResourceException ex) {
            localeBundle = NULL_BUNDLE;
        }
    }
}