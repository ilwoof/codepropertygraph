package io.shiftleft.passes.dataflows

import io.shiftleft.codepropertygraph.generated.nodes
import io.shiftleft.passes.dataflows.steps.{TrackingPoint, TrackingPointMethods}
import io.shiftleft.queryprimitives.Implicits.GremlinScalaDeco
import io.shiftleft.queryprimitives.steps.Steps
import shapeless.HList

object Implicits {
  // TODO MP: rather use `start` mechanism?
  // alternative: move to `nodes` package object?
  implicit def trackingPointBaseMethodsQp(node: nodes.TrackingPointBase): TrackingPointMethods =
    new TrackingPointMethods(node.asInstanceOf[nodes.TrackingPoint])

  implicit def toTrackingPoint[NodeType <: nodes.TrackingPointBase, Labels <: HList](
      steps: Steps[NodeType, Labels]): TrackingPoint[Labels] =
    new TrackingPoint[Labels](steps.raw.cast[nodes.TrackingPoint])
}
