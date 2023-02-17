package com.chaottic.toyle

import com.chaottic.toyle.parser.ToyleProperty
import com.chaottic.toyle.parser.ToyleTypes

object ToylePsiUtil {
	private const val empty = ""

	fun getKey(property: ToyleProperty): String {
		return property.node.findChildByType(ToyleTypes.IDENTIFIER)?.text ?: empty
	}

	fun getValue(property: ToyleProperty) = empty
}