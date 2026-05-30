/** packages for gui */
import java.awt.BorderLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

/** main function to run everthing */
fun main() {

    /** Sets up GUI */
    val frame = JFrame("Draw")

    /** brings in DrawLines Class */
    val drawlines = Drawlines()

    /** sets up buttons for tools */
    val penButton = JButton("Pen")
    val rectangle = JButton("Rectangle")
    val oval = JButton("Oval")
    val clearButton = JButton("Clear")

    /** action listenrs for buttons */
    /** basic lines */
    penButton.addActionListener {
        drawlines.currentTool = Tools.PEN
    }

    /** rectangle */
    rectangle.addActionListener {
        drawlines.currentTool = Tools.RECTANGLE
    }

    /** circles*/
    oval.addActionListener {
        drawlines.currentTool = Tools.OVAL
    }

    /** clear */
    clearButton.addActionListener {
        drawlines.clear()
    }

    /** gives tools its own panel */

    val toolItems = JPanel()

    /** adds tools to own pannel */
    toolItems.add(penButton)
    toolItems.add(rectangle)
    toolItems.add(oval)
    toolItems.add(clearButton)

    /** sets up layout */

    frame.layout = BorderLayout()

    /** adds tools and drawing items */

    frame.add(toolItems, BorderLayout.NORTH)
    frame.add(drawlines, BorderLayout.CENTER)

    /** sets up frame size. needs to exist to use initially */
    frame.setSize(600, 600)

    /** closes gui */
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

    /** so that you can actaully see the gui */
    frame.isVisible = true
}

