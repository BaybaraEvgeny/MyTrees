class Node<K: Comparable<K>, V>(var key: K, var value: V) {

    var parent: Node<K, V>? = null
    var left: Node<K, V>? = null
    var right: Node<K, V>? = null

    fun isLeaf(): Boolean = ((right == null) && (left == null))

    fun high(): Int {

        var currentNode = this
        var count = 0
        while (currentNode.parent != null) {
            currentNode = currentNode.parent!!
            count++
        }
        return count

    }

    fun branch(): String = when {
        this.parent == null -> ""
        this.key > this.parent!!.key -> "/"
        else -> "\\"
    }

    override fun toString() = this.value.toString()

    override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (other !is Node<*, *>) return false

        if (key != other.key) return false
        if (value != other.value) return false

        return true

    }

}