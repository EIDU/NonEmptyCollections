## Overview

We have decided to stop using this library however it is heavily embedded in many services so it's not feasible to remove
it in one shot. Instead we are taking the following approach..

- Remove NonEmptyCollection from `sharedlibaries:util` (renamed to `sharedlibaries:kotlin-extensions`)
  - This stops it being included in every dependency by default
- Existing util/extension functions move here
  - Keeping the `com.eidu.sharedlibaries.util` package allows for easier migration
- Deprecate those util/extension functions
   - Communicates that new development features should not be using them
   - Communicates that usage should be removed at some point

The eventual goal is to archive this repo
