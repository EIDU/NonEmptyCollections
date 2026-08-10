package com.eidu.sharedlibraries.util

import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import kotlin.enums.enumEntries

@Deprecated("Do not depend on this library. Use a normal List instead.")
@OptIn(ExperimentalStdlibApi::class)
inline fun <reified T : Enum<T>> enumEntries(): NonEmptyList<T> =
  enumEntries<T>().toNonEmptyListOr { error("Enum class ${T::class.simpleName} has no values") }
