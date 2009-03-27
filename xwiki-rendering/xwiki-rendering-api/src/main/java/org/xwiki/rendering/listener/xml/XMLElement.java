/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.listener.xml;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents an XML element.
 * 
 * @version $Id$
 * @since 1.7M2
 */
public class XMLElement extends XMLNode
{
    /**
     * The name of the element.
     */
    private String name;

    /**
     * The attributes of the element.
     */
    private Map<String, String> attributes;

    /**
     * @param name the name of the element.
     */
    public XMLElement(String name)
    {
        this(name, Collections.<String, String> emptyMap());
    }

    /**
     * @param name the name of the element.
     * @param attributes the attributes of the element.
     */
    public XMLElement(String name, Map<String, String> attributes)
    {
        super();
        this.name = name;

        // Make sure we preserve the order provided to us so that getAttributes() will return the same order.
        this.attributes = new LinkedHashMap<String, String>(attributes);
    }

    /**
     * @return the name of the element.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return the attributes of the element
     */
    public Map<String, String> getAttributes()
    {
        return Collections.unmodifiableMap(this.attributes);
    }

    /**
     * @param name the name of the attribute to add/modify.
     * @param value the value of the attribute to add/modify.
     */
    public void setAttribute(String name, String value)
    {
        this.attributes.put(name, value);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.xwiki.rendering.listener.xml.XMLNode#getNodeType()
     */
    @Override
    public XMLNodeType getNodeType()
    {
        return XMLNodeType.ELEMENT;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append('[').append(getName()).append(']');
        if (this.attributes.size() > 0) {
            buffer.append(' ').append('[');
            for (Iterator<String> it = this.attributes.keySet().iterator(); it.hasNext();) {
                String attributeName = it.next();
                buffer.append(attributeName).append("=").append(this.attributes.get(attributeName));
                if (it.hasNext()) {
                    buffer.append(",");
                }
            }
            buffer.append(']');
        }

        return buffer.toString();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.xwiki.rendering.listener.xml.XMLNode#clone()
     */
    @Override
    public XMLNode clone()
    {
        XMLElement node = (XMLElement) super.clone();
        node.attributes = new LinkedHashMap<String, String>(getAttributes());

        return node;
    }
}
