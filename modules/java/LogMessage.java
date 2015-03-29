/*
 * Copyright (c) 2014 BalaBit IT Ltd, Budapest, Hungary
 * Copyright (c) 2014 Viktor Juhasz <viktor.juhasz@balabit.com>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As an additional exemption you are allowed to compile & link against the
 * OpenSSL libraries as published by the OpenSSL project. See the file
 * COPYING for details.
 *
 */

package org.syslog_ng;

public class LogMessage {
  private long handle;

  public LogMessage(long handle) {
    this.handle = handle;
  }

  public String getValue(String name) {
    return getValue(handle, name);
  }

  public void setValue(String name, String value) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name cannot be empty");
    }
    if (value == null) {
      throw new IllegalArgumentException("Value cannot be null");
    }

    setValue(handle, name, value);
  }

  public void release() {
    unref(handle);
    handle = 0;
  }

  protected long getHandle() {
    return handle;
  }

  private native void unref(long handle);
  private native String getValue(long ptr, String name);
  private native void setValue(long ptr, String name, String value);
}
