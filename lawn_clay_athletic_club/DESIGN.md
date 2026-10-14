---
name: Lawn & Clay Athletic Club
colors:
  surface: '#f9faf5'
  surface-dim: '#d9dad6'
  surface-bright: '#f9faf5'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f3f4ef'
  surface-container: '#edeee9'
  surface-container-high: '#e7e9e4'
  surface-container-highest: '#e2e3de'
  on-surface: '#1a1c19'
  on-surface-variant: '#414845'
  inverse-surface: '#2e312e'
  inverse-on-surface: '#f0f1ec'
  outline: '#717975'
  outline-variant: '#c1c8c3'
  surface-tint: '#3f6658'
  primary: '#002218'
  on-primary: '#ffffff'
  primary-container: '#0f382c'
  on-primary-container: '#79a292'
  inverse-primary: '#a6d0be'
  secondary: '#5b6300'
  on-secondary: '#ffffff'
  secondary-container: '#dfec60'
  on-secondary-container: '#616a00'
  tertiary: '#291900'
  on-tertiary: '#ffffff'
  tertiary-container: '#442d00'
  on-tertiary-container: '#c78f22'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#c1ecda'
  primary-fixed-dim: '#a6d0be'
  on-primary-fixed: '#002117'
  on-primary-fixed-variant: '#274e41'
  secondary-fixed: '#dfec60'
  secondary-fixed-dim: '#c2cf47'
  on-secondary-fixed: '#1a1d00'
  on-secondary-fixed-variant: '#444b00'
  tertiary-fixed: '#ffdead'
  tertiary-fixed-dim: '#fabc4d'
  on-tertiary-fixed: '#281900'
  on-tertiary-fixed-variant: '#604100'
  background: '#f9faf5'
  on-background: '#1a1c19'
  surface-variant: '#e2e3de'
typography:
  display:
    fontFamily: Space Grotesk
    fontSize: 56px
    fontWeight: '600'
    lineHeight: 64px
  display-mobile:
    fontFamily: Space Grotesk
    fontSize: 36px
    fontWeight: '600'
    lineHeight: 44px
  headline-lg:
    fontFamily: Space Grotesk
    fontSize: 36px
    fontWeight: '500'
    lineHeight: 44px
  headline-lg-mobile:
    fontFamily: Space Grotesk
    fontSize: 28px
    fontWeight: '500'
    lineHeight: 36px
  headline-md:
    fontFamily: Space Grotesk
    fontSize: 24px
    fontWeight: '500'
    lineHeight: 32px
  headline-sm:
    fontFamily: Space Grotesk
    fontSize: 20px
    fontWeight: '500'
    lineHeight: 28px
  body-lg:
    fontFamily: Hanken Grotesk
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Hanken Grotesk
    fontSize: 15px
    fontWeight: '400'
    lineHeight: 22px
  body-sm:
    fontFamily: Hanken Grotesk
    fontSize: 13px
    fontWeight: '400'
    lineHeight: 18px
  label-lg:
    fontFamily: JetBrains Mono
    fontSize: 14px
    fontWeight: '500'
    lineHeight: 20px
  label-md:
    fontFamily: JetBrains Mono
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
  label-sm:
    fontFamily: JetBrains Mono
    fontSize: 10px
    fontWeight: '600'
    lineHeight: 14px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  gutter: 1.25rem
  gutter-mobile: 0.75rem
  margin: 3rem
  margin-mobile: 1rem
  space-xs: 0.25rem
  space-sm: 0.5rem
  space-md: 1rem
  space-lg: 1.5rem
  space-xl: 2.5rem
---

## Brand & Style

The brand evokes the heritage, poise, and exacting precision of world-class racquet clubs, modernized into an effortless digital booking platform. Designed for discerning club members, touring amateurs, and modern athletes, the interface communicates prestige without stiffness, blending high-performance athletic functionality with boutique hospitality.

The visual style merges Modern Architectural Minimalism with Subtle Tactile Luxury. It emphasizes deep verdant greens reminiscent of manicured grass courts, warm clay undertones, and vivid optical tennis-ball accents for actionable alerts and live statuses. Layouts prioritize generous breathing room, razor-sharp typography, and bespoke scheduling grids that make complex availability intuitive and frictionless.

## Colors

- **Primary (`#0F382C`)**: Deep tournament forest green. Grounding, authoritative, and elegant. Used for primary branding, structural headers, high-emphasis text, and core active button states. A secondary tier (`#184A3B`) handles hover states, selected card fills, and rich surface backgrounds.
- **Secondary (`#D4E157`)**: Volt tennis-ball chartreuse. High energy, contemporary, and unmistakable. Reserved for high-priority interactive highlights, available instant-booking indicators, live match tracking, and badges.
- **Tertiary (`#E5A93C`)**: Warm court clay amber. Conveys warmth and surface heritage. Utilized for secondary action highlights, reserved slot markers, VIP tiers, and notification badges.
- **Neutral (`#F4F5F0`)**: Unbleached chalk / soft stone gray. Serves as the base canvas to prevent eye fatigue under bright club lighting, paired with stark white (`#FFFFFF`) containers and deep charcoal text (`#121916`) for maximum legibility.

## Typography

The typographic pairing balances performance engineering with bespoke editorial authority:

- **Headlines (`Space Grotesk`)**: Technical, structured, and modern. Its geometric posture and slightly boxy proportions reflect court boundary markings and sports precision.
- **Body (`Hanken Grotesk`)**: Clean, neutral, and exceptionally legible. Provides effortless readability across court profiles, booking disclaimers, and account ledgers.
- **Labels, Numbers & Timers (`JetBrains Mono`)**: Monospaced clarity for timestamps, court numbers (e.g., `CRT 04`), match durations, and availability matrices. It ensures aligned time columns and evokes official scoreboards.

## Layout & Spacing

The layout is built upon a flexible 12-column system on desktop and tablet, collapsing to a 4-column system on mobile devices.

- **Desktop (1024px+)**: Max-width container of 1440px with `3rem` lateral margins. Court schedule grids employ horizontal hour axes paired with vertical court rows.
- **Tablet (768px - 1023px)**: Fluid layouts with `1.5rem` margins and `1rem` gutters. Interactive time selectors shift to horizontally scrollable rails.
- **Mobile (< 768px)**: Strict 4-column structure with `1rem` margins and `0.75rem` gutters. The daily booking view shifts to accordion-based court cards or single-court timeline columns with fixed bottom checkout sheets.
- **Grid Density**: Component gaps and slot pills adhere strictly to an 8pt modular scale, ensuring consistent cadence between dense availability matrices and open editorial content.

## Elevation & Depth

Visual hierarchy uses a refined hybrid of tonal surface stacking and subtle ambient shadows:

- **Level 0 (Canvas)**: Neutral stone tint (`#F4F5F0`).
- **Level 1 (Cards & Modules)**: Pure white (`#FFFFFF`) with a whisper-light shadow tinted by deep forest green (`rgba(15, 56, 44, 0.04) 0px 4px 16px`) and a delicate `1px` inner hairline border (`#E4E7E1`).
- **Level 2 (Active Slots & Dropdowns)**: Elevated panels receive an enhanced lift (`rgba(15, 56, 44, 0.08) 0px 8px 24px`) with crisp border emphasis.
- **Level 3 (Modals & Sticky Booking Bars)**: Floating booking confirmations and time-slot drawers float cleanly with an ambient blur shadow (`rgba(15, 56, 44, 0.16) 0px 16px 40px`) ensuring immediate focus over dimming scrims.
- **Glass Overlays**: Filter headers and sticky court navigators use subtle semi-transparency (`rgba(244, 245, 240, 0.88)` with `backdrop-filter: blur(12px)`) for lightweight scrolling contexts.

## Shapes

The design system employs a calibrated **Rounded (`2`)** shape hierarchy:

- Standard controls, court matrix cells, and utility cards carry a `0.5rem` (8px) radius, conveying architectural precision without sharp, uninviting edges.
- Larger court feature modules and dialogs scale to `1rem` (`rounded-lg`) and `1.5rem` (`rounded-xl`).
- Dynamic interactive badges, player avatars, surface type indicator pills (Grass, Clay, Hard Court), and quick status chips maintain complete circular/pill geometry (`9999px`) to contrast against rectilinear schedule tracks.

## Components

### Buttons
- **Primary**: Solid deep forest green (`#0F382C`) background with crisp white typography. Hover state transitions to `#184A3B`. Focused states feature a `2px` offset ring in `#D4E157`.
- **Secondary / Volt**: Accent fill (`#D4E157`) with deep green text (`#0F382C`) for immediate calls-to-action like "Book Court Now" or "Instant Reserve".
- **Tertiary / Outline**: Transparent fill, `1px` border in `#0F382C`, hover state fills with `rgba(15, 56, 44, 0.05)`.
- **Ghost**: Padding-only controls for calendar navigation and header actions.

### Court Availability Grid & Time Slots
- **Available Slot**: Crisp white card cell, bordered in `#E4E7E1`, monospaced start/end times in `JetBrains Mono`. Hover transitions border to `#0F382C`.
- **Selected Slot**: Inverted fill in `#0F382C` with secondary chartreuse text (`#D4E157`), communicating an active booking in real-time.
- **Reserved / Occupied Slot**: Soft neutral stone fill (`#EBECE7`), muted strikethrough or member lock icon, non-interactive.
- **Premium / Prime Time Slot**: Subtle clay accent border (`#E5A93C`) with small upper badge indicating peak club hours.

### Cards
- **Court Overview Card**: Features high-resolution imagery with a surface pill overlay (e.g., "Championship Clay" in amber or "Tournament Grass" in dark green), current indoor/outdoor temperature indicator, lighting status, and next open time slot.
- **Reservation Card**: Dedicated white container showing member profile, court number, booking window, equipment add-ons, and cancellation countdown.

### Chips & Badges
- Compact pill-shaped badges (`rounded-full`, padding `4px 10px`).
- Monospaced labels (`JetBrains Mono`, 11px uppercase).
- Variants include:
  - `Surface`: Grass (`#0F382C` text, soft green tint bg), Clay (`#E5A93C` text, warm sand bg), Hard Court (`#1E3A8A` text, light slate bg).
  - `Status`: Live/Open (`#D4E157` dot, green bg), Maintenance (`#EF4444` dot, light rose bg).

### Input Fields & Selectors
- Background: Pure white `#FFFFFF` with `#E4E7E1` border and `8px` corner radius.
- Member ID, date, and duration pickers utilize tabular figures in `JetBrains Mono`.
- Active focus state: Deep green `#0F382C` border with subtle outer glow.

### Checkboxes & Radios
- Crisp `18px` squares/circles with `1.5px` borders in `#0F382C`.
- Checked state fills with `#0F382C` showcasing a bright white or volt checkmark.