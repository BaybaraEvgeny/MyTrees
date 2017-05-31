import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class InsertionTest {

    @Test
    fun insertInRoot() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(10, 10)
        root.color = false

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        actualTree.insert(10, 10)

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun insertInLeaf() {
        val expectedTree = RedBlackTree<Int,Int>()

        val root = RBNode(10,10)
        root.color = false
        val right = RBNode(15,15)
        right.color = true
        root.right = right
        right.parent = root
        expectedTree.root = root


        val actualTree = RedBlackTree<Int,Int>()
        actualTree.insert(10,10)
        actualTree.insert(15,15)

        assertEquals(expectedTree, actualTree)

    }
    @Test
    fun RootColor(){
        var Tree = RedBlackTree<Int,Int>()
        var random = Random()
        for (i in 1..1000) {
            Tree.insert(random.nextInt(), random.nextInt())
            assertEquals(Tree.root!!.color, false)
        }

    }

    @Test
    fun insertcaseBothRed() {//Nodes father is red && uncle is red
        var expectedTree = RedBlackTree<Int, Int>()

        var actualTree = RedBlackTree<Int, Int>()

        expectedTree.root = RBNode(2,2)
        expectedTree.root!!.color = false
        expectedTree.root!!.right = RBNode(3,3)
        expectedTree.root!!.right!!.color = false
        expectedTree.root!!.right!!.parent = expectedTree.root
        expectedTree.root!!.left = RBNode(1,1)
        expectedTree.root!!.left!!.color = false
        expectedTree.root!!.left!!.parent = expectedTree.root
        expectedTree.root!!.right!!.right = RBNode(4,4)
        expectedTree.root!!.right!!.right!!.color = true
        expectedTree.root!!.right!!.right!!.parent = expectedTree.root!!.right
        actualTree.insert(2,2)
        actualTree.insert(1,1)
        actualTree.insert(3,3)
        actualTree.insert(4,4)
        assertEquals(expectedTree,actualTree)

    }

    @Test
    fun insertRightRightCase() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        val node2 = RBNode(30, 30)
        root.right = node2
        node2.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 25, 30)) {
            actualTree.insert(i, i)
        }

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun insertRightLeftCase() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        val node2 = RBNode(30, 30)
        root.right = node2
        node2.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 30, 25)) {
            actualTree.insert(i, i)
        }

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun insertLeftLeftCase() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        val node2 = RBNode(30, 30)
        root.right = node2
        node2.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(30, 25, 20)) {
            actualTree.insert(i, i)
        }

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun insertLeftRightCase() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        val node2 = RBNode(30, 30)
        root.right = node2
        node2.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf( 30, 20, 25)) {
            actualTree.insert(i, i)
        }

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun insertRecoloringRelatives() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root
        node1.color = false

        val node2 = RBNode(30, 30)
        root.right = node2
        node2.parent = root
        node2.color = false

        val node3 = RBNode(40, 40)
        node2.right = node3
        node3.parent = node2

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 25, 30, 40)) {
            actualTree.insert(i, i)
        }

        assertEquals(expectedTree, actualTree)

    }

    @Test
    fun insertIllegalKeyValue() {

        val expectedTree = RedBlackTree<Int, Int>()

        val root = RBNode(25, 25)
        root.color = false

        val node1 = RBNode(20, 20)
        root.left = node1
        node1.parent = root

        val node2 = RBNode(30, 30)
        root.right = node2
        node2.parent = root

        expectedTree.root = root

        val actualTree = RedBlackTree<Int, Int>()

        for (i in listOf(20, 25, 30)) {
            actualTree.insert(i, i)
        }

        actualTree.insert(null, 40)
        actualTree.insert(40, null)
        actualTree.insert(null, null)

        assertEquals(expectedTree, actualTree)

    }

}