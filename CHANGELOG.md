# Changelog
All notable changes to the project will be documented in this file.

This project *attempts* to follow [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), 
and this project also *attempts* to adhere to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased](https://github.com/Periwinks/HeavenMS/compare/master...sprint)

## [0.0.0] - 2019-08-06
### Added
- Created CHANGELOG
- Cloto repeats quiz question when given incorrect coupon count
- Basic MTS (wanted, auction not yet implemented)
- Onyx chest exchanges (items not final; only gives onyx apples)
- Ability to propose to character of the same sex (giftlist NPC buttons will still say bride and groom) (credits to Arnah and Ubaware for the address/help!)
- Buff icons for summons (credits to ronancpl!)
- Cash Shop name changes (credits to Ubaware!)
- Todo command (GmLv2)
- Setname command changes name of self or a victim character (GmLv4)
- Clearinv command clears an inventory of type <all | equipped | eqp | use | ins | etc | cash> (GmLv4)
- Copychar command (GmLv4)
- Npc option to !debug command (GmLv5)
- Morph command (GmLv5)
- incAp() in npc conversation manager for luckarium's return
- BGM strings for invoking updated bgm
- Victim parameter for levelpro, level, face, hair commands
- PlayerStorage wipe()
- CashShopInventory wipe()
- Cash Shop world transfers (credits to Ubaware!)

### Changed
- Snipe no longer deals a flat damage amount, but scales with your character :blush:
- Wedding wait times decreased
- EXP Loss and safety charm loss will no longer take place in event maps or towns
- EXP Loss formula now ranges from 15% and 50%
- Command arguments are now case sensitive
- Item, morph id range spans increased to incorporate future version styles

### Fixed
- Characters begin with the correct total AP amount (25)
- Beginners job advancing gain SP based on their level (for those who were late to job advance)
- Physical, Magical, Hybrid damage reflect mob buffs now work properly
- Love Fairy Nana in Magatia and Boat Quay give out the proper KC quest
- Players no longer become stuck in guild creation proposal if one rejects (credits to kolakcc!)
- Spiruna improper aran quest dialog no longer stucks players (credits to ronancpl!)
- Combat Step effect no longer appears twice for other players (credits to ronancpl!)
- Gaviota properly disappear after attacking once (credits to ronancpl!)

### Security
- I am no longer given admin benefits :sob:
- Reduced pink bean map false positives
