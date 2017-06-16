package com.chinasoft.junling.service;

import java.util.List;

import com.chinasoft.junling.bean.Books;

public interface IBookService {
	List<Books> queryBooks(Books books);
}
