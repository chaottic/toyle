package com.chaottic.toyle.compile

import org.gradle.language.base.internal.compile.Compiler

interface ToyleCompiler<T : ToyleCompileSpec> : Compiler<T>