// Copyright 2018 Sebastian Kuerten
//
// This file is part of thatsberlin-java.
//
// thatsberlin-java is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// thatsberlin-java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with thatsberlin-java. If not, see <http://www.gnu.org/licenses/>.

package com.thatsberlin.datafiles;

import java.util.List;

import com.google.common.base.Splitter;
import com.vividsolutions.jts.geom.Coordinate;

public class Parsing
{

	private static Splitter splitter = Splitter.on(",").trimResults();

	public static Coordinate coordinate(String value)
	{
		List<String> parts1 = splitter.splitToList(value);
		double x1 = Double.parseDouble(parts1.get(0));
		double y1 = Double.parseDouble(parts1.get(1));
		return new Coordinate(x1, y1);
	}

}
