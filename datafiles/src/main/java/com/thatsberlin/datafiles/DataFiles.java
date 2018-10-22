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

import java.io.IOException;
import java.nio.file.Path;

public class DataFiles
{

	public static int INDENT = 25;

	public static String KEY_NAME = "name";
	public static String KEY_OSM_RELATION = "osm-relation";
	public static String KEY_COMPUTED_CENTROIDS = "computed-centroid";
	public static String KEY_COMPUTED_AREA = "computed-area";
	public static String KEY_BEZIRK = "bezirk";
	public static String KEY_NEIGHBORS = "neighbors";
	public static String KEY_WIKIDATA = "wikidata";

	public static DataFile data(Path file) throws IOException
	{
		DataFileReader reader = new DataFileReader(file);
		DataFile data = reader.read();
		reader.close();
		return data;
	}

}
