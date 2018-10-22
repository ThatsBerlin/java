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

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataFileWriter implements AutoCloseable, Closeable
{

	private BufferedWriter writer;
	private int padding;

	public DataFileWriter(Path path, int padding) throws IOException
	{
		this.padding = padding;
		writer = Files.newBufferedWriter(path);
	}

	public void write(String key, String value) throws IOException
	{
		writeKey(key);
		writer.write(value);
		writer.newLine();
	}

	public void write(String key, long value) throws IOException
	{
		writeKey(key);
		writer.write(Long.toString(value));
		writer.newLine();
	}

	private void writeKey(String key) throws IOException
	{
		StringBuilder buf = new StringBuilder();
		buf.append(key);
		buf.append(':');
		int pad = padding - key.length() - 1;
		for (int i = 0; i < pad; i++) {
			buf.append(' ');
		}
		writer.write(buf.toString());
	}

	@Override
	public void close() throws IOException
	{
		writer.close();
	}

}
