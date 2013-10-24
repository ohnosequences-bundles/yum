package ohnosequences.statika

import ohnosequences.statika._

class YumBundle(packageName: String) extends Bundle() {

  def install[D <: AnyDistribution](d: D): InstallResults =
    Seq("yum", "install", "-y", packageName) ->- success(name + " is installed")

}

case object GCC extends YumBundle("gcc")

case object Python extends YumBundle("python")

case object ZlibDevel extends YumBundle("zlib-devel")

case object Git extends YumBundle("git") {
  // TODO: check url for format correctness
  def clone(repo: String, dir: String = ""): InstallResults =
    Seq("git", "clone", repo) ++ (if (dir.isEmpty) Seq() else Seq(dir))
}
