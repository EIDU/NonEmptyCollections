package com.eidu.sharedlibraries.util

import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.map.NonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet
import com.quickbirdstudios.nonEmptyCollection.set.toNonEmptySet
import com.quickbirdstudios.nonEmptyCollection.toNonEmptyListOr
import com.quickbirdstudios.nonEmptyCollection.toNonEmptyListOrNull
import com.quickbirdstudios.nonEmptyCollection.toNonEmptyMapOr
import com.quickbirdstudios.nonEmptyCollection.toNonEmptySetOr

@Deprecated("Do not depend on this library. Use a normal List instead.")
inline fun <T> Array<T>.toNonEmptyListOr(alternative: Array<T>.() -> NonEmptyList<T>): NonEmptyList<T> =
  toNonEmptyListOrNull() ?: alternative()

@Deprecated("Do not depend on this library. Use a normal Set instead.")
inline fun <T> Array<T>.toNonEmptySetOr(alternative: Array<T>.() -> NonEmptySet<T>): NonEmptySet<T> =
  toNonEmptySetOrNull() ?: alternative()

@Deprecated("Do not depend on this library. Use a normal List instead.")
inline fun <T> Iterable<T>.toNonEmptyListOr(alternative: Iterable<T>.() -> NonEmptyList<T>): NonEmptyList<T> =
  toNonEmptyListOrNull() ?: alternative()

@Deprecated("Do not depend on this library. Use a normal Set instead.")
inline fun <T> Iterable<T>.toNonEmptySetOr(alternative: Iterable<T>.() -> NonEmptySet<T>): NonEmptySet<T> =
  toNonEmptyListOrNull()?.toNonEmptySet() ?: alternative()

@Deprecated("Do not depend on this library. Use a normal List instead.")
fun <T> Array<T>.toNonEmptyListOrNull(): NonEmptyList<T>? = asIterable().toNonEmptyListOrNull()

@Deprecated("Do not depend on this library. Use a normal Set instead.")
fun <T> Array<T>.toNonEmptySetOrNull(): NonEmptySet<T>? = asIterable().toNonEmptySetOrNull()

@Deprecated("Do not depend on this library. Use a normal List instead.")
fun <T> Iterable<T>.toNonEmptyListOrNull(): NonEmptyList<T>? = toList().toNonEmptyListOrNull()

@Deprecated("Do not depend on this library. Use a normal Set instead.")
fun <T> Iterable<T>.toNonEmptySetOrNull(): NonEmptySet<T>? = toNonEmptyListOrNull()?.toNonEmptySet()

@Deprecated("Do not depend on this library. Use a normal List instead.")
inline fun <T : Any> nonEmptyListOfNotNullOr(
  vararg elements: T?,
  noinline alternative: List<T>.() -> NonEmptyList<T>,
): NonEmptyList<T> = listOfNotNull(elements = elements).toNonEmptyListOr(alternative)

@Deprecated("Do not depend on this library. Use a normal Set instead.")
fun <T : Any> nonEmptySetOfNotNullOr(vararg elements: T?, alternative: Set<T>.() -> NonEmptySet<T>): NonEmptySet<T> =
  setOfNotNull(elements = elements).toNonEmptySetOr(alternative)

@Deprecated("Do not depend on this library. Use a normal List instead.")
inline fun <T> requireNonEmpty(iterable: Iterable<T>, crossinline lazyMessage: () -> String): NonEmptyList<T> =
  iterable.toNonEmptyListOr {
    throw IllegalArgumentException(lazyMessage())
  }

@Deprecated("Do not depend on this library. Use a normal Set instead.")
inline fun <T> requireNonEmpty(set: Set<T>, crossinline lazyMessage: () -> String): NonEmptySet<T> =
  set.toNonEmptySetOr {
    throw IllegalArgumentException(lazyMessage())
  }

@Deprecated("Do not depend on this library. Use a normal Map instead.")
inline fun <K, V> requireNonEmpty(map: Map<K, V>, crossinline lazyMessage: () -> String): NonEmptyMap<K, V> =
  map.toNonEmptyMapOr {
    throw IllegalArgumentException(lazyMessage())
  }
