/*
 * CaellianCore, universal library
 * Copyright (C) 2015 Caellian
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.caellyan.core.versionControl;

import com.sun.istack.internal.NotNull;

import java.net.URL;
import java.util.Optional;

/**
 * Class used to store and handle version data.
 * Created by Caellian on 3.7.2015., at 15:24.
 */
@SuppressWarnings("unused")
public class VersionData implements Comparable<VersionData>
{
	public final Version          version;
	public final Optional<String> name;
	public final Optional<String> changelog;
	public final Optional<URL>    downloadLink;

	public VersionData(Version version)
	{
		this(version, Optional.<String>empty(), Optional.<String>empty(), Optional.<URL>empty());
	}

	public VersionData(Version version, Optional<String> name, Optional<String> changelog, Optional<URL> downloadLink)
	{
		this.version = version;
		this.name = name;
		this.changelog = changelog;
		this.downloadLink = downloadLink;
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public int compareTo(@NotNull VersionData other)
	{
		return this.version.major - other.version.major == 0 ? (this.version.minor - other.version.minor == 0 ? (this.version.patch - other.version.patch == 0 ? 0 : (this.version.patch - other.version.patch)) : (this.version.minor - other.version.minor)) : (this.version.major - other.version.major);
	}

}
