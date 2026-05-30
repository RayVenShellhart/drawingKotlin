/** packages so that you can draw with color and mouse */
import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel

/**Creates panel for drawlines */
class Drawlines : JPanel() {

    /** Keeps track of whats drawn */
    private val points = mutableListOf<Drawdata>()
    private val shapes = mutableListOf<DrawShapes>()

    /** default tool is the lines */
    var currentTool = Tools.PEN

    /** sets up tools and background color */
    init {
        background = Color.WHITE


        /** When mouse is clicked and you have one of the tools equipped it well draw */
        addMouseListener( object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                /** tool for rectangle */
                when (currentTool) {
                    Tools.RECTANGLE ->
                        shapes.add(
                            DrawShapes(
                                TypeShape.RECTANGLE,
                                e.x,
                                e.y,
                                100,
                                100

                            )
                        )

                    /** tool for oval*/
                    Tools.OVAL ->
                        shapes.add(
                            DrawShapes(
                                TypeShape.OVAL,
                                e.x,
                                e.y,
                                100,
                                100

                            )
                        )

                    Tools.PEN -> {}
                }

                repaint()
            }
        }
        )

        /** tool for lines */
        addMouseMotionListener (object : MouseAdapter() {

            override fun mouseDragged(e: MouseEvent) {

                if (currentTool == Tools.PEN) {

                points.add(
                    Drawdata(
                        e.x, e.y
                    )
                )

                repaint()
            }}

        })
    }

    /** clear canvas function */
    fun clear() {
        points.clear()
        shapes.clear()

        repaint()
    }


    /** part that lets you draw */
    override fun paintComponent(g: Graphics) {

        super.paintComponent(g)

        /** change this to draw in different colors */
        g.color = Color.BLACK

        for (point in points) {

            /** To draw with lines */
            g.fillOval(point.x, point.y, 8, 8)
        }

        for (shape in shapes) {
            /** to draw with shapes */
            when (shape.type) {
                TypeShape.OVAL -> {
                    g.drawOval(shape.x, shape.y, shape.width, shape.height)
                }
                TypeShape.RECTANGLE -> {
                    g.drawRect(shape.x, shape.y, shape.width, shape.height)
                }
            }
        }
    }

}