import pureconfig.ConfigReader
import pureconfig.generic.derivation.default.derived

object Config {

  // We need this because in application.conf, it's just a String
  given ConfigReader[SpecialId] =
    ConfigReader.fromString(s => Right(SpecialId(s)))

  /* Since this one's just a wrapper, we use our special ConfigReader
  instead of using the default derived one like a normal case-class. */
  case class SpecialId(s: String)

  // This one NEEDS the `derives` clause because of the SpecialId
  case class FlatConfig(id: SpecialId, amount: Int) derives ConfigReader

  case class ServerConfig(
      host: String,
      port: Int
  ) // derives ConfigReader (works either way)

  case class ApplicationConfig(
      items: List[FlatConfig],
      serverConfig: ServerConfig
  ) derives ConfigReader
}
