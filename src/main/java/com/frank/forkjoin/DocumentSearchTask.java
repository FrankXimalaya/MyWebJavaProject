package com.frank.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 *
 *妈的，真正拆分的思想也没有在compute方法中显示
 *
 */

public class DocumentSearchTask extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;

	private final Document document;
	private final String searchedWord;

	DocumentSearchTask(Document document, String searchedWord) {
		super();
		this.document = document;
		this.searchedWord = searchedWord;
	}

	@Override
	protected Long compute() {
		return WordCounter.occurrencesCount(document, searchedWord);
	}

}
