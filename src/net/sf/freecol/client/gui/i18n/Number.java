/**
 *  Copyright (C) 2002-2011  The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.client.gui.i18n;

/**
 * Classes implementing this interface can determine the category and
 * the index of a double based on the number rules for a language.
 *
 * @See http://cldr.unicode.org/index/cldr-spec/plural-rules
 */
public abstract class Number implements Selector {

    public enum Category { zero, one, two, few, many, other };

    /**
     * Return the category input belongs to.
     *
     * @param input a <code>double</code> value
     * @return a <code>Category</code> value
     */
    public abstract Category getCategory(double input);

    /**
     * {@inheritDoc}
     */
    public String getKey(String input) {
        return getKey(Double.parseDouble(input));
    }

    /**
     * Return the key of the rule this input matches. The key is the
     * string representation of the Category.
     *
     * @param input a <code>double</code> value
     * @return a <code>String</code> value
     */
    public String getKey(double input) {
        return getCategory(input).toString();
    }
}