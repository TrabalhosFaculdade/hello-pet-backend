package br.mackenzie.hellopet.database.model.utils

interface ConvertibleEnum<T, V> where T : Enum<T>, T : ConvertibleEnum<T, V> {

    companion object {

        fun <T, V> fromValue(clazz: Class<T>, value: V): T where T : Enum<T>, T : ConvertibleEnum<T, V> {

            clazz.enumConstants.forEach {
                if (it.getValue()!! == value) {
                    return it
                }
            }

            throw IllegalArgumentException("Could not find type for specified value")
        }

    }

    fun getValue(): V
}
