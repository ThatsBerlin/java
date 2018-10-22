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

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFileReader implements AutoCloseable, Closeable
{

	private BufferedReader reader;

	public DataFileReader(Path path) throws IOException
	{
		reader = Files.newBufferedReader(path);
	}

	public DataFile read() throws IOException
	{
		List<String> order = new ArrayList<>();
		Map<String, String> data = new HashMap<>();
		while (true) {
			String line = reader.readLine();
			if (line == null) {
				break;
			}
			String[] parts = line.split(":", 2);
			order.add(parts[0]);
			data.put(parts[0], parts[1].trim());
		}
		return new DataFile(order, data);
	}

	@Override
	public void close() throws IOException
	{
		reader.close();
	}

}
