import pureconfig.ConfigReader
import pureconfig.generic.derivation.default.derived

object Config {

  given ConfigReader[SpecialId] =
    ConfigReader.fromString(s => Right(SpecialId(s)))

  case class SpecialId(s: String)

  case class FlatConfig(id: SpecialId, amount: Int) derives ConfigReader

  case class ServerConfig(host: String, port: Int)

  case class ApplicationConfig(
      items: List[FlatConfig],
      serverConfig: ServerConfig
  ) derives ConfigReader
}
