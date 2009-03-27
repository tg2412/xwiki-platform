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
package org.xwiki.rendering.block;

import org.xwiki.rendering.listener.Listener;

/**
 * @version $Id$
 * @since 1.5M2
 */
public final class SpaceBlock extends AbstractBlock
{
    /**
     * A unique instance of {@link SpaceBlock}.
     */
    public static final SpaceBlock SPACE_BLOCK = new SpaceBlock();

    /**
     * Use {@link #SPACE_BLOCK} instead.
     */
    private SpaceBlock()
    {
        // We need to keep this constructor to override the ones in AbstractBlock
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.xwiki.rendering.block.Block#traverse(org.xwiki.rendering.listener.Listener)
     */
    public void traverse(Listener listener)
    {
        listener.onSpace();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.xwiki.rendering.block.AbstractBlock#clone()
     */
    @Override
    public Block clone()
    {
        return this;
    }
}
