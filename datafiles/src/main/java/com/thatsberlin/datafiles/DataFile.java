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
import java.util.Map;

public class DataFile
{

	private List<String> order;
	private Map<String, String> data;

	public DataFile(List<String> order, Map<String, String> data)
	{
		this.order = order;
		this.data = data;
	}

	public List<String> getOrder()
	{
		return order;
	}

	public void setOrder(List<String> order)
	{
		this.order = order;
	}

	public Map<String, String> getData()
	{
		return data;
	}

	public void setData(Map<String, String> data)
	{
		this.data = data;
	}

	public String get(String key)
	{
		return data.get(key);
	}

	public void put(String key, String value)
	{
		if (!order.contains(key)) {
			order.add(key);
		}
		data.put(key, value);
	}

}
