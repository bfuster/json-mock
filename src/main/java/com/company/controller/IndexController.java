package com.company.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.company.model.JsonMock;
import com.googlecode.objectify.Key;
import com.squaremarks.gaeofy.datastore.DataStoreTemplate;

@Resource
public class IndexController {

	private final Result result;
	private final DataStoreTemplate ds;

	public IndexController(Result result, DataStoreTemplate ds) {
		this.result = result;
		this.ds = ds;
	}

	@Post("/add")
	public void index(JsonMock mock) {
		
		Key<JsonMock> key = ds.save(mock);
		result.redirectTo("/"+key.getId());
	}
	
	@Get("/{id}")
	public void view(Long id) {
		
		JsonMock mock = ds.get(new Key<JsonMock>(JsonMock.class, id));
		result.use(Results.http()).addHeader("content-type", "application/json");
		result.use(Results.http()).body(mock.getJson());
		
	}
	
}
