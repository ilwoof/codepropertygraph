package io.shiftleft.fuzzyc2cpg

import io.shiftleft.codepropertygraph.generated.{NodeKeys, NodeTypes}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MethodDeclTest extends AnyWordSpec with Matchers {

  private val fixture = CpgTestFixture("methoddecl")

  "MethodDeclTest" should {
    "omit the method declaration in presence of a definition" in {
      val result = fixture.traversalSource
        .label(NodeTypes.METHOD)
        .l

      result.size shouldBe 1
      val signature = result.head.property(NodeKeys.SIGNATURE)
      signature shouldBe "int add (int,int)"
    }
  }
}
