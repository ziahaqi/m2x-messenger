/*
 * OpenYMSG, an implementation of the Yahoo Instant Messaging and Chat protocol.
 * Copyright (C) 2007 G. der Kinderen, Nimbuzz.com 
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA. 
 */
package org.openymsg.network;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a single group of friend users in a Yahoo friends list.
 * 
 * @author G. der Kinderen, Nimbuzz B.V. guus@nimbuzz.com
 * @author S.E. Morris
 */
/*
 * TODO: manipulating the group should also cause relevant packets to be sent to the network.
 */
public class YahooGroup {
    private String name;

    private boolean isOpen;

    private TreeSet<YahooUser> users;

    /**
     * Creates a new YahooGroup instance.
     * 
     * @param name
     *            Name of the group.
     * @param isOpen
     *            ''true'' the create an open group, ''false'' otherwise.
     */
    public YahooGroup(final String name, final boolean isOpen) {
        this.name = name;
        this.isOpen = isOpen;
        this.users = new TreeSet<YahooUser>(YahooUser.getComparator());
    }

    /**
     * Creates a new, open group.
     * 
     * @param name
     *            Name of the group.
     */
    public YahooGroup(final String name) {
        this(name, true);
    }

    public void addUser(final YahooUser yu) {
        this.users.add(yu);
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nm) {
        this.name = nm;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setOpen(final boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setUsers(final Set<YahooUser> users)
    {
    	this.users = (TreeSet<YahooUser>) users;    	
    }
    
    public Set<YahooUser> getUsers() {
        return this.users;
    }

    @Override
    public String toString() {
        return "YahooGroup [name=" + this.name + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
			return true;
        if (obj == null)
			return false;
        if (!(obj instanceof YahooGroup))
			return false;
        final YahooGroup other = (YahooGroup) obj;
        if (this.name == null) {
            if (other.name != null)
				return false;
        }
        else if (!this.name.equals(other.name))
			return false;
        return true;
    }
}
