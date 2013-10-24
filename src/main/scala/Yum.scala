package ohnosequences.statika

import ohnosequences.statika._

case object Yum extends Bundle() {

  def install[D <: AnyDistribution](d: D): InstallResults = {
    // do someting here
    success(name + " is installed")
  }

}
