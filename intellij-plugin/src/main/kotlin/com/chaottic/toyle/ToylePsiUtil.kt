package com.chaottic.toyle

import com.chaottic.toyle.parser.ToyleProperty
import com.chaottic.toyle.parser.ToyleTypes

object ToylePsiUtil {
	private const val nullstr = ""

	fun getKey(property: ToyleProperty): String {
		return property.node.findChildByType(ToyleTypes.IDENTIFIER)?.text ?: nullstr
	}

	fun getValue(property: ToyleProperty): String {
		return nullstr
	}
}