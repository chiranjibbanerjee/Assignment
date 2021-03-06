package com.chiranjib.assignment.model


/**
 * POJO class for the JSON
 */


data class Response(
	val title: String? = null,
	val rows: List<RowsItem?>? = null
)

data class RowsItem(
	val imageHref: String? = null,
	val description: String? = null,
	val title: String? = null
)

