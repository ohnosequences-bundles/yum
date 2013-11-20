package ohnosequences.statika.bundles

import ohnosequences.statika._

abstract class YumBundle(packageName: String) extends Bundle() {

  override def install[D <: AnyDistribution](d: D): InstallResults =
    Seq("yum", "install", "-y", packageName) ->- success(name + " is installed")

}

case object Git extends YumBundle("git") {
  // TODO: check url for format correctness
  def clone(repo: String, dir: String = ""): InstallResults =
    Seq("git", "clone", repo) ++ (if (dir.isEmpty) Seq() else Seq(dir))
}
